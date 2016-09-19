package com.mills.organiser.models.relations;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mills.organiser.models.Neo4JModel;
import com.mills.organiser.models.nodes.Event;
import com.mills.organiser.models.nodes.Person;
import org.joda.time.DateTime;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import java.util.Date;

/**
 * Created by ryan on 23/08/16.
 */
@RelationshipEntity(type = "INVITED")
public class Invitation extends Neo4JModel {
    @StartNode
    private Event _event;
    @EndNode
    private Person _person;
    @Property
    private Date _createdAt;

    private Invitation() {
    }

    public Invitation(Event event, Person person) {
        _event = event;
        _person = person;
        _createdAt = DateTime.now().toDate();
    }

    public Person getPerson() {
        return _person;
    }

    public void setPerson(Person _person) {
        this._person = _person;
    }

    public Date getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    public Event getEvent() {
        return _event;
    }

    public void setEvent(Event _event) {
        this._event = _event;
    }
}
