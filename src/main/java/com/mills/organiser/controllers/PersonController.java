package com.mills.organiser.controllers;

import com.mills.organiser.models.nodes.Person;
import com.mills.organiser.repositories.PersonRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmills on 23/08/2016.
 */
@Api(name = "people",
        visibility = ApiVisibility.PUBLIC,
        stage = ApiStage.GA,
        description = "Methods for viewing and manipulating people")
@ApiVersion(since = "1.0")
@ApiAuthNone
@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonRepository _personRepository;

    @RequestMapping
    public List<Person> getPersons() {
        List<Person> people = new ArrayList<>();
        for (Person person : _personRepository.findAll(0)) {
            people.add(person);
        }
        return people;
    }

}
