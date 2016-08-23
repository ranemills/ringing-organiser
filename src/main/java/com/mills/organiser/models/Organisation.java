package com.mills.organiser.models;

import com.mills.organiser.enums.RelationshipType;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by ryanmills on 23/08/2016.
 */
public class Organisation {

    @GraphId
    private Long _id;

    @Property
    private String _name;

//    @Relationship(type= "HAS_EVENT", direction = Relationship.UNDIRECTED)
//    private List<Event> _events;

    private Organisation() {}

    public Organisation(String name) {
        _name = name;
    }

//    public void addEvent(Event event) {
//        _events.add(event);
//    }

}
