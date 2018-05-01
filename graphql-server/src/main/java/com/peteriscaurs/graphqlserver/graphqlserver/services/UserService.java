package com.peteriscaurs.graphqlserver.graphqlserver.services;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.CreateUserInput;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.SignInPayload;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.User;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.UsersRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author peteris-caurs
 */
@Component
public class UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public User createUser(CreateUserInput input) {
        User user = new User(
                null,
                null,
                input.getEmail(),
                input.getPassword()
        );

        return usersRepository.save(user);
    }

    public SignInPayload signInUser(CreateUserInput createUserInput) {
        User user = usersRepository.findByEmail(createUserInput.getEmail());
        if (user.getPassword().equals(createUserInput.getPassword())) {
            return new SignInPayload(user.getId(), user);
        }
        throw new GraphQLException("Invalid credentials");
    }
}
