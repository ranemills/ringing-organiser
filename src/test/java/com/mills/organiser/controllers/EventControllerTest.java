package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.models.nodes.Person;
import com.mills.organiser.models.relations.Invitation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
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

    private static final String TEST_EVENT = "testEvent";
    private static final String TEST_PERSON = "testPerson";

    @Test
    public void shouldCreateEventForOrganisation()
            throws Exception {
        mockMvc.perform(post("/events")
                .contentType(contentType)
                .content(json(new Event(TEST_EVENT))))
                .andExpect(status().isOk());

        List<Event> events = listFromIterable(_eventRepository.findAll());
        assertThat(events, hasSize(1));
        assertThat(events.get(0).getName(), is(TEST_EVENT));
    }

    @Test
    public void shouldInvitePerson()
            throws Exception {
        Event event = _eventRepository.save(new Event(TEST_EVENT));
        Person person = _personRepository.save(new Person(TEST_PERSON));
        mockMvc.perform(post("/events/" + event.getId() + "/invitations/" + person.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(nullValue())))
                .andExpect(jsonPath("$.event.name", is(TEST_EVENT)))
                .andExpect(jsonPath("$.person.name", is(TEST_PERSON)));
    }

    @Test
    public void shouldReturnEmptyList()
            throws Exception {
        mockMvc.perform(get("/events").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
