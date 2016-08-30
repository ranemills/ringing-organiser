package com.mills.organiser.controllers;

import com.mills.organiser.models.Organisation;
import com.mills.organiser.repositories.OrganisationRepository;
import org.apache.commons.lang3.RandomUtils;
import org.jsondoc.core.annotation.*;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
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
@Api(name="organisations", visibility = ApiVisibility.PUBLIC, stage = ApiStage.GA, description = "Methods for viewing and manipulating organisations")
@ApiVersion(since = "1.0")
@ApiAuthNone
@RestController
@RequestMapping("/organisations")
public class OrganisationController {

    @Autowired
    OrganisationRepository _organisationRepository;

    @ApiMethod
    @RequestMapping
    public @ApiResponseObject List<Organisation> getOrganisations() {
        List<Organisation> organisations = new ArrayList<>();
        for(Organisation organisation : organisations) {
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
