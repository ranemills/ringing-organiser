package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Organisation;
import com.mills.organiser.repositories.OrganisationRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmills on 23/08/2016.
 */
@RestController
@RequestMapping("/organisations")
public class OrganisationController {

    @Autowired
    OrganisationRepository _organisationRepository;

    @RequestMapping
    public List<Organisation> getOrganisations() {
        List<Organisation> organisations = new ArrayList<>();
        for(Organisation organisation : _organisationRepository.findAll(0))
        {
            organisations.add(organisation);
        }
        return organisations;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void createOrganisation() {
        int randInt = RandomUtils.nextInt(0, 100000);
        Organisation organisation = new Organisation("Test" + randInt);
        _organisationRepository.save(organisation);
    }

}
