package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Person;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ryan on 31/08/16.
 */
public class PersonControllerTest extends IntegrationTest {

    @Test
    public void shouldReturnEmptyList()
            throws Exception {
        mockMvc.perform(get("/people").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldReturnOrganisations()
            throws Exception {
        _personRepository.save(new Person("testName"));
        mockMvc.perform(get("/people").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("testName")));
    }
}
