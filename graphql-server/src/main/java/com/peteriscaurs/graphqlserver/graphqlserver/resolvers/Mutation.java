package com.peteriscaurs.graphqlserver.graphqlserver.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.*;
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

    public User signUpUser(SignUpInput input) {
        return userService.signUpUser(input);
    }

    public SignInPayload signInUser(SignInInput input) {
        return userService.signInUser(input);
    }

    public User addWordToFavorites(AddWordToFavoritesInput input) {
        return userService.addWordToFavorites(input);
    }

}
