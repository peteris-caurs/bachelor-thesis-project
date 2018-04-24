package com.peteriscaurs.graphqlserver.graphqlserver.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.Word;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.WordInput;
import com.peteriscaurs.graphqlserver.graphqlserver.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author peteris-caurs
 */
@Component
public class Query implements GraphQLQueryResolver {

    private WordService wordService;

    @Autowired
    public Query(WordService wordService) {
        this.wordService = wordService;
    }

    public List<Word> allWords() {
        return wordService.getAllWords();
    }

    public List<Word> specifiedWords(WordInput params) {
        return wordService.getSpecifiedWords(params);
    }

}
