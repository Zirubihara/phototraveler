package com.phototraveler.phototraveler.Assembler;

import com.phototraveler.phototraveler.Controller.QuestController;
import com.phototraveler.phototraveler.Model.Quest;
import com.phototraveler.phototraveler.Model.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class QuestModelAssembler implements RepresentationModelAssembler<Quest, EntityModel<Quest>> {

    @Override
    public EntityModel<Quest> toModel(Quest quest) {
        EntityModel<Quest> questModel = EntityModel.of(quest,
                linkTo(methodOn(QuestController.class).one(quest.getId())).withSelfRel(),
                linkTo(methodOn(QuestController.class).all()).withRel("quests"));

        if (quest.getStatus() == Status.IN_PROGRESS) {
            questModel.add(linkTo(methodOn(QuestController.class).cancel(quest.getId())).withRel("cancel"));
            questModel.add(linkTo(methodOn(QuestController.class).complete(quest.getId())).withRel("complete"));
        }
        return questModel;
    }


}
