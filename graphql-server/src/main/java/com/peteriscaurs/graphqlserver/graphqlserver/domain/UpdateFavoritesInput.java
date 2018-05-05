package com.peteriscaurs.graphqlserver.graphqlserver.domain;

public class UpdateFavoritesInput {

    private String userId;
    private String wordId;

    public UpdateFavoritesInput() { }

    public UpdateFavoritesInput(String userId, String wordId) {
        this.userId = userId;
        this.wordId = wordId;
    }

    public String getUserId() {
        return userId;
    }

    public String getWordId() {
        return wordId;
    }

}
