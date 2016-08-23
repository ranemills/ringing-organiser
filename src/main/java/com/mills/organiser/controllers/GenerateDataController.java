package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.models.nodes.Organisation;
import com.mills.organiser.models.nodes.Person;
import com.mills.organiser.models.relations.Invitation;
import com.mills.organiser.repositories.InvitationRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 23/08/16.
 */
@RestController
@RequestMapping("/create")
public class GenerateDataController {

    @Autowired
    private GraphRepository<Person> _personRepository;
    @Autowired
    private GraphRepository<Event> _eventRepository;
    @Autowired
    private GraphRepository<Organisation> _organisationRepository;
    @Autowired
    private InvitationRepository _invitationRepository;

    @RequestMapping(method = RequestMethod.PUT)
    public void createData() {
        Organisation organisation = new Organisation("test");
//        _organisationRepository.save(organisation);

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person("testPerson" + i);
            organisation.addPerson(person);
            people.add(person);
//            _personRepository.save(person);
//            _organisationRepository.save(organisation);
        }
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Event event = new Event("testEvent" + i);
            organisation.addEvent(event);
//            _organisationRepository.save(organisation);
            events.add(event);
            for (int j = 0; j < 5; j++) {
                int index = RandomUtils.nextInt(0, 4);
                Invitation invitation = new Invitation(event, people.get(index));
//                _invitationRepository.save(invitation);
                event.addInvitiation(invitation);
//                _eventRepository.save(event);
            }
        }
        _organisationRepository.save(organisation);


    }

}
