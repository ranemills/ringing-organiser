package com.mills.organiser.controllers;

import com.mills.organiser.models.Organisation;
import com.mills.organiser.repositories.OrganisationRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmills on 23/08/2016.
 */
@RestController("/organisations")
public class OrganisationController {

    @Autowired
    OrganisationRepository _organisationRepository;

    @RequestMapping
    public Organisation getOrganisations() {
        return _organisationRepository.findAll().iterator().next();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void createOrganisation() {
        int randInt = RandomUtils.nextInt(0, 100000);
        Organisation organisation = new Organisation("Test" + randInt);
        _organisationRepository.save(organisation);
    }

}
