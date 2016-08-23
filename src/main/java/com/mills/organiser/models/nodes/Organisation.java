package com.mills.organiser.models.nodes;

import com.mills.organiser.models.Neo4JModel;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmills on 23/08/2016.
 */
public class Organisation extends Neo4JModel {
    @Property
    private String _name;
    @Relationship(type = "HAS_EVENT")
    private List<Event> _events;
    @Relationship(type = "HAS_PERSON")
    private List<Person> _people;

    private Organisation() {
    }

    public Organisation(String name) {
        _people = new ArrayList<>();
        _events = new ArrayList<>();
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public List<Event> getEvents() {
        return _events;
    }

    public List<Person> getPeople() {
        return _people;
    }

    public void addEvent(Event event) {
        _events.add(event);
    }

    public void addPerson(Person person) {
        _people.add(person);
    }

}
