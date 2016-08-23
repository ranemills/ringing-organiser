package com.mills.organiser.models;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by ryanmills on 23/08/2016.
 */
@NodeEntity
public class Event {

    @GraphId
    private Long _id;

    @Property
    private String _name;

    private Event() {}

    public Event(String name) {
        this._name = name;
    }

}
