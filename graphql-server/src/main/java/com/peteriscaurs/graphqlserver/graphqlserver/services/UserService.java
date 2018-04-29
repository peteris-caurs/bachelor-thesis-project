package com.peteriscaurs.graphqlserver.graphqlserver.services;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.CreateUserInput;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.User;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.UsersRepository;
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
}
