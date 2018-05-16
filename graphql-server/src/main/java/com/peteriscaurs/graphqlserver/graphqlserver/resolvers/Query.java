package com.peteriscaurs.graphqlserver.graphqlserver.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.peteriscaurs.graphqlserver.graphqlserver.types.user.User;
import com.peteriscaurs.graphqlserver.graphqlserver.types.word.Word;
import com.peteriscaurs.graphqlserver.graphqlserver.types.word.FindWordsInput;
import com.peteriscaurs.graphqlserver.graphqlserver.services.UserService;
import com.peteriscaurs.graphqlserver.graphqlserver.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private WordService wordService;
    private UserService userService;

    @Autowired
    public Query(WordService wordService, UserService userService) {
        this.wordService = wordService;
        this.userService = userService;
    }

    public List<Word> findWordsBy(FindWordsInput params) {
        return wordService.findWordsBy(params);
    }

    public List<User> findUsers() {
        return userService.getUsers();
    }

}
