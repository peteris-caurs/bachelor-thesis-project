package com.peteriscaurs.graphqlserver.graphqlserver.domain;

/**
 * @author peteris-caurs
 */
public class FindWordsInput {

    private String startsWith;
    private String endsWith;
    private PosTag posTag;
    private int limit;
    private int maxLength;

    public FindWordsInput() {
        this.startsWith = "";
        this.endsWith = "";
//        this.posTag = PosTag.NOUN;
        this.limit = Integer.MAX_VALUE;
        this.maxLength = 15;
    }

    public FindWordsInput(String startsWith, String endsWith, PosTag posTag, int limit, int maxLength) {
        this.startsWith = startsWith;
        this.endsWith = endsWith;
        this.posTag = posTag;
        this.limit = limit;
        this.maxLength = maxLength;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public String getEndsWith() {
        return endsWith;
    }

    public PosTag getPosTag() {
        return posTag;
    }

    public int getLimit() {
        return limit;
    }

    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public String toString() {
        return "FindWordsInput{" +
                "startsWith='" + startsWith + '\'' +
                ", endsWith='" + endsWith + '\'' +
                ", limit=" + limit +
                ", maxLength=" + maxLength +
                '}';
    }
}
