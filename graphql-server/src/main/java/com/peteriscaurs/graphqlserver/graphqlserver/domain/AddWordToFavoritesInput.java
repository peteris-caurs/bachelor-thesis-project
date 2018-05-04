package com.peteriscaurs.graphqlserver.graphqlserver.domain;

public class AddWordToFavoritesInput {

    private String userId;
    private String wordId;

    public AddWordToFavoritesInput() { }

    public AddWordToFavoritesInput(String userId, String wordId) {
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
