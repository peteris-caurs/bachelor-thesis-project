package com.peteriscaurs.graphqlserver.graphqlserver.repositories;

import com.peteriscaurs.graphqlserver.graphqlserver.types.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
