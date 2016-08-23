package com.mills.organiser.models.nodes;

import com.mills.organiser.models.Neo4JModel;
import com.mills.organiser.models.relations.Invitation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 23/08/16.
 */
@NodeEntity
public class Person extends Neo4JModel {

    @Property
    private String _name;

    @Relationship(type = "INVITED", direction = Relationship.UNDIRECTED)
    private List<Invitation> _invitations;

    private Person() {}

    public Person(String name) {
        _invitations = new ArrayList<>();
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public List<Invitation> getInvitations() {
        return _invitations;
    }

    public void addInvitation(Invitation invitation) {
        _invitations.add(invitation);
    }
}
