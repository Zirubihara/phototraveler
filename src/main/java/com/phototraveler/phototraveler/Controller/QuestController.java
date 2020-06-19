package com.phototraveler.phototraveler.Controller;

import com.phototraveler.phototraveler.Assembler.QuestModelAssembler;
import com.phototraveler.phototraveler.Exception.QuestNotFoundException;
import com.phototraveler.phototraveler.Model.Quest;
import com.phototraveler.phototraveler.Model.Status;
import com.phototraveler.phototraveler.Repository.QuestRepository;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class QuestController {

    private final QuestRepository questRepository;
    private final QuestModelAssembler assembler;

    public QuestController(QuestRepository questRepository, QuestModelAssembler assembler) {
        this.questRepository = questRepository;
        this.assembler = assembler;
    }

    @GetMapping(path = "/quests", produces = "application/pt.app-v1.0+json")
    public CollectionModel<EntityModel<Quest>> all() {
        List<EntityModel<Quest>> quests = questRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(quests,
                linkTo(methodOn(QuestController.class).all()).withSelfRel());
    }

    @GetMapping(path = "/quests/{id}", produces = "application/pt.app-v1.0+json")
    public EntityModel<Quest> one(@PathVariable Long id) {

        Quest quest = questRepository.findById(id)
                .orElseThrow(() -> new QuestNotFoundException(id));

        return assembler.toModel(quest);
    }

    @PostMapping(path = "/quests", produces = "application/pt.app-v1.0+json")
    ResponseEntity<EntityModel<Quest>> newQuest(@RequestBody Quest quest) {

        quest.setStatus(Status.IN_PROGRESS);
        Quest newQuest = questRepository.save(quest);

        return ResponseEntity
                .created(linkTo(methodOn(QuestController.class).one(newQuest.getId())).toUri())
                .body(assembler.toModel(newQuest));
    }

    @DeleteMapping(path = "/quests/{id}/cancel", produces = "application/pt.app-v1.0+json")
    public ResponseEntity<?> cancel(@PathVariable Long id) {
        Quest quest = questRepository.findById(id)
                .orElseThrow(() -> new QuestNotFoundException(id));

        if (quest.getStatus() == Status.IN_PROGRESS) {
            quest.setStatus(Status.CANCELLED);
            return ResponseEntity.ok(assembler.toModel(questRepository.save(quest)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create() //
                        .withTitle("Method not allowed") //
                        .withDetail("You can't cancel an order that is in the " + quest.getStatus() + " status"));
    }
    @PutMapping(path = "/quests/{id}/complete", produces = "application/pt.app-v1.0+json")
    public ResponseEntity<?> complete(@PathVariable Long id) {

        Quest quest = questRepository.findById(id)
                .orElseThrow(()->new QuestNotFoundException(id));
        if (quest.getStatus()==Status.IN_PROGRESS){
            quest.setStatus(Status.COMPLETED);
            return ResponseEntity.ok(assembler.toModel(questRepository.save(quest)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(Problem.create()
                .withTitle("Method now allowed")
                .withDetail("YOu can't complete an order that is in the " + quest.getStatus()));
    }
}
