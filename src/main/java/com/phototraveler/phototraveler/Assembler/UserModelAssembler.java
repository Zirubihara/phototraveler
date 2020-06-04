package com.phototraveler.phototraveler.Assembler;

import com.phototraveler.phototraveler.Controller.UserController;
import com.phototraveler.phototraveler.Model.User;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;
import javax.jws.soap.SOAPBinding;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                //linkTo(methodOn(UserController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("employees"));    }
}
