package com.peteriscaurs.graphqlserver.graphqlserver.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.CreateUserInput;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.SignInPayload;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.User;
import com.peteriscaurs.graphqlserver.graphqlserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author peteris-caurs
 */
@Component
public class Mutation implements GraphQLMutationResolver {

    private UserService userService;

    @Autowired
    public Mutation(UserService userService) {
        this.userService = userService;
    }

    public User createUser(CreateUserInput createUserInput) {
        return userService.createUser(createUserInput);
    }

    public SignInPayload signInUser(CreateUserInput createUserInput) {
        return userService.signInUser(createUserInput);
    }

}
