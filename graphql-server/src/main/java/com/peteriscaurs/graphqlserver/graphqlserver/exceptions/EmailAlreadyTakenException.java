package com.peteriscaurs.graphqlserver.graphqlserver.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author peteris-caurs
 */
public class EmailAlreadyTakenException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public EmailAlreadyTakenException(String message, String email) {
        super(message);
        extensions.put("email", email);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

}
