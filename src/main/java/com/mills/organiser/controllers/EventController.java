package com.mills.organiser.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.mills.organiser.View;
import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.models.nodes.Person;
import com.mills.organiser.models.relations.Invitation;
import com.mills.organiser.repositories.EventRepository;
import com.mills.organiser.repositories.InvitationRepository;
import com.mills.organiser.repositories.PersonRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmills on 23/08/2016.
 */
@Api(name = "events",
        visibility = ApiVisibility.PUBLIC,
        stage = ApiStage.GA,
        description = "Methods for viewing and manipulating events")
@ApiVersion(since = "1.0")
@ApiAuthNone
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventRepository _eventRepository;
    @Autowired
    PersonRepository _personRepository;
    @Autowired
    InvitationRepository _invitationRepository;

    @JsonView(View.Common.class)
    @RequestMapping
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        for (Event event : _eventRepository.findAll(1)) {
            events.add(event);
        }
        return events;
    }

    @JsonView(View.Common.class)
    @RequestMapping(method = RequestMethod.POST)
    public Event createEvent(@RequestBody Event event) {
        return _eventRepository.save(event);
    }

    @JsonView(View.WithInvitationList.class)
    @RequestMapping("/{eventId}")
    public Event getEvent(@PathVariable Long eventId) {
        return _eventRepository.findOne(eventId);
    }

    @JsonView(View.Common.class)
    @RequestMapping("/{eventId}/invitations")
    public List<Invitation> getInvitations(@PathVariable Long eventId) {
        return _eventRepository.findOne(eventId).getInvitations();
    }

    @JsonView(View.Common.class)
    @RequestMapping(value = "/{eventId}/invitations/{personId}", method= RequestMethod.POST)
    public Invitation invitePerson(@PathVariable("eventId") Long eventId, @PathVariable("personId") Long personId) {
        Event event = _eventRepository.findOne(eventId);
        Person person = _personRepository.findOne(personId);

        Invitation invitation = new Invitation(event, person);
        event.addInvitiation(invitation);
        person.addInvitation(invitation);

        _eventRepository.save(event);

        return invitation;
    }

}
