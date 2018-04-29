package com.peteriscaurs.graphqlserver.graphqlserver.repositories;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author peteris-caurs
 */
public interface UsersRepository extends MongoRepository<User, String> {
}
