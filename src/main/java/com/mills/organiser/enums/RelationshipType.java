package com.mills.organiser.enums;

/**
 * Created by ryanmills on 23/08/2016.
 */
public enum RelationshipType {
    HAS_EVENT("HAS_EVENT");

    private final String _name;

    RelationshipType(String name)
    {
        _name = name;
    }

    @Override
    public String toString()
    {
        return _name;
    }
}
