package com.mills.organiser.models.relations;

import com.fasterxml.jackson.annotation.JsonView;
import com.mills.organiser.View;
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

    @JsonView(View.Common.class)
    public Person getPerson() {
        return _person;
    }

    public void setPerson(Person _person) {
        this._person = _person;
    }

    @JsonView(View.Common.class)
    public Date getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    @JsonView(View.Common.class)
    public Event getEvent() {
        return _event;
    }

    public void setEvent(Event _event) {
        this._event = _event;
    }
}
