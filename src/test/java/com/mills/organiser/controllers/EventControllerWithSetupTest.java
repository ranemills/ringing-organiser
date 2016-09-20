package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.models.nodes.Person;
import com.mills.organiser.models.relations.Invitation;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ryanmills on 20/09/2016.
 */
public class EventControllerWithSetupTest extends IntegrationTest {

    private static final String EVENT_1 = "Event1";
    private static final String EVENT_2 = "Event2";
    private static final String PERSON_1 = "Person1";
    private static final String PERSON_2 = "Person2";

    private Event event1;
    private Event event2;
    private Person person1;
    private Person person2;

    @Before
    public void setup() {
        event1 = new Event(EVENT_1);
        event2 = new Event(EVENT_2);
        person1 = new Person(PERSON_1);
        person2 = new Person(PERSON_2);

        Invitation invitation1 = new Invitation(event1, person1);
        Invitation invitation2 = new Invitation(event1, person2);
        Invitation invitation3 = new Invitation(event2, person2);

        _invitationRepository.save(Arrays.asList(invitation1, invitation2, invitation3));
    }

    @Test
    public void shouldReturnEvents()
            throws Exception {
        mockMvc.perform(get("/events").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(EVENT_1)))
                .andExpect(jsonPath("$[1].name", is(EVENT_2)));
    }

    @Test
    public void canRetrieveEventDetails()
            throws Exception {
        mockMvc.perform(get("/events/" + event1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", not(nullValue())))
                .andExpect(jsonPath("$.name", is(EVENT_1)))
                .andExpect(jsonPath("$.invitations", hasSize(2)));
    }

    @Test
    public void canRetrieveEventInvitations()
            throws Exception {
        mockMvc.perform(get("/events/" + event1.getId() + "/invitations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].event.name", is(EVENT_1)))
                .andExpect(jsonPath("$[0].person.name", is(PERSON_1)))
                .andExpect(jsonPath("$[1].event.name", is(EVENT_1)))
                .andExpect(jsonPath("$[1].person.name", is(PERSON_2)));
    }
}
