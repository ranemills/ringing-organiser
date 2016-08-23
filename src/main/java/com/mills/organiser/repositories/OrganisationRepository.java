package com.mills.organiser.repositories;

import com.mills.organiser.models.Organisation;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by ryanmills on 23/08/2016.
 */
public interface OrganisationRepository extends GraphRepository<Organisation> {

}
