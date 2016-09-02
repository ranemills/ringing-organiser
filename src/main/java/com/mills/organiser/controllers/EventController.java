package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.repositories.EventRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping
    public List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        for (Event event : _eventRepository.findAll(0)) {
            events.add(event);
        }
        return events;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createEvent(@RequestBody Event event) {
        _eventRepository.save(event);
    }

}
