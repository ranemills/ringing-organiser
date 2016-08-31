package com.mills.organiser.repositories;

import com.mills.organiser.models.Organisation;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * Created by ryanmills on 23/08/2016.
 */
@Service
public interface OrganisationRepository extends GraphRepository<Organisation> {

}
