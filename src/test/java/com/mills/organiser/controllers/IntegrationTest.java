package com.mills.organiser.controllers;

import com.mills.organiser.repositories.EventRepository;
import com.mills.organiser.repositories.InvitationRepository;
import com.mills.organiser.repositories.OrganisationRepository;
import com.mills.organiser.repositories.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ryanmills on 02/09/2016.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(secure = false)
public abstract class IntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected EventRepository _eventRepository;
    @Autowired
    protected OrganisationRepository _organisationRepository;
    @Autowired
    protected PersonRepository _personRepository;
    @Autowired
    protected InvitationRepository _invitationRepository;

    protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Before
    public void cleanDatabase() {
        _eventRepository.deleteAll();
        _organisationRepository.deleteAll();
        _personRepository.deleteAll();
        _invitationRepository.deleteAll();
    }

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }


    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }



    protected <T> List<T> listFromIterable(Iterable<T> iterable)
    {
        List<T> list = new ArrayList<T>();
        for(T item : iterable)
        {
            list.add(item);
        }
        return list;
    }
}
