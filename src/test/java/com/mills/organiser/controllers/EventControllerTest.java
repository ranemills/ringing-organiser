package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.models.nodes.Organisation;
import com.mills.organiser.models.nodes.Person;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ryan on 31/08/16.
 */
public class EventControllerTest extends IntegrationTest {


    @Test
    public void shouldReturnEmptyList()
            throws Exception {
        mockMvc.perform(get("/events").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldReturnEvents()
            throws Exception {
        _eventRepository.save(new Event("testEvent"));
        mockMvc.perform(get("/events").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("testEvent")));
    }

    @Test
    public void shouldCreateEventForOrganisation()
            throws Exception {
        mockMvc.perform(post("/events").contentType(contentType).content(json(new Event("testEvent"))))
                .andExpect(status().isOk());

        List<Event> events = listFromIterable(_eventRepository.findAll());
        assertThat(events, hasSize(1));
        assertThat(events.get(0).getName(), is("testEvent"));
    }

    @Test
    public void canRetrieveEventDetails()
        throws Exception {
        Event event = _eventRepository.save(new Event("testEvent"));
        mockMvc.perform(get("/events/" + event.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(nullValue())))
                .andExpect(jsonPath("$['name']", is("testEvent")));
    }

    @Test
    public void shouldInvitePerson()
        throws Exception {
        Event event = _eventRepository.save(new Event("testEvent"));
        Person person = _personRepository.save(new Person("testPerson"));
        mockMvc.perform(post("/events/"+event.getId()+"/invitations/"+person.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(nullValue())))
                .andExpect(jsonPath("$.event.name", is("testEvent")))
                .andExpect(jsonPath("$.person.name", is("testPerson")));
    }

}
