package com.phototraveler.phototraveler.Controller;

import com.phototraveler.phototraveler.Assembler.UserModelAssembler;
import com.phototraveler.phototraveler.Exception.UserNotFoundException;
import com.phototraveler.phototraveler.Model.User;
import com.phototraveler.phototraveler.Repository.UserRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;

    public UserController(UserRepository userRepository, UserModelAssembler userModelAssembler) {
        this.userRepository = userRepository;
        this.userModelAssembler = userModelAssembler;
    }

    @GetMapping(path = "/users", produces = "application/pt.app-v1.0+json")
    public CollectionModel<EntityModel<User>> all() {

        List<EntityModel<User>> users = userRepository.findAll().stream()
                .map(userModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }


    @GetMapping(path = "/users/{id}", produces = "application/pt.app-v1.0+json")
    public EntityModel<User> one(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return userModelAssembler.toModel(user);
    }

    @PostMapping(path = "/users", produces = "application/pt.app-v1.0+json")
    ResponseEntity<?> newUser(@RequestBody User newUser) {
        EntityModel<User> entityModel = userModelAssembler.toModel(userRepository.save(newUser));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @PutMapping(path = "/user/{id}", produces = "application/pt.app-v1.0+json")
    ResponseEntity<?> replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        User updateUser = userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setLogin(newUser.getLogin());
                    user.setNazwisko(newUser.getNazwisko());
                    return userRepository.save(newUser);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
        EntityModel<User> entityModel = userModelAssembler.toModel(updateUser);

        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);

    }

    @DeleteMapping(path = "/user/{id}", produces = "application/pt.app-v1.0+json")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
