package com.mills.organiser.models.nodes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mills.organiser.models.Neo4JModel;
import com.mills.organiser.models.relations.Invitation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryanmills on 23/08/2016.
 */
@NodeEntity
public class Event extends Neo4JModel {

    @Property
    private String _name;

    @JsonManagedReference
    @Relationship(type = "INVITED", direction = Relationship.UNDIRECTED)
    private List<Invitation> _invitations;

    private Event() {
    }

    public Event(String name) {
        _invitations = new ArrayList<>();
        this._name = name;
    }

    public List<Invitation> getInvitations() {
        return _invitations;
    }

    public void setInvitations(List<Invitation> _invitations) {
        this._invitations = _invitations;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void addInvitiation(Invitation invitation) {
        _invitations.add(invitation);
    }

}
