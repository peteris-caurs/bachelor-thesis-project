package com.peteriscaurs.graphqlserver.graphqlserver.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

/**
 * @author peteris-caurs
 */
public class InvalidCredentialsException extends RuntimeException implements GraphQLError {

    public InvalidCredentialsException(String message) {
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

}
