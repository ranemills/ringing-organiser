package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.models.nodes.Organisation;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
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
    public void shouldReturnOrganisations()
            throws Exception {
        _eventRepository.save(new Event("testName"));
        mockMvc.perform(get("/events").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("testName")));
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

}
