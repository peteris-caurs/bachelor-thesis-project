package com.peteriscaurs.graphqlserver.graphqlserver.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.Word;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peteris-caurs
 */
@Component
public class Query implements GraphQLQueryResolver {

    public List<Word> getWords() {
        // TODO: provide implementation using a service
        return new ArrayList<>();
    }

}
