package com.mills.organiser.models;

import org.neo4j.ogm.annotation.GraphId;

/**
 * Created by ryan on 23/08/16.
 */
public abstract class Neo4JModel {
    @GraphId
    private Long _id;

    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
    }
}