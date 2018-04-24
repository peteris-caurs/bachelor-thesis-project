package com.peteriscaurs.graphqlserver.graphqlserver.domain;

/**
 * @author peteris-caurs
 */
public class WordInput {

    private String startsWith;
    private String endsWith;
    private int wordLimit;
    private int lengthLessThan;

    public WordInput() { }

    public WordInput(String startsWith, String endsWith, int wordLimit, int lengthLessThan) {
        this.startsWith = startsWith;
        this.endsWith = endsWith;
        this.wordLimit = wordLimit;
        this.lengthLessThan = lengthLessThan;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public void setStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }

    public String getEndsWith() {
        return endsWith;
    }

    public void setEndsWith(String endsWith) {
        this.endsWith = endsWith;
    }

    public int getWordLimit() {
        return wordLimit;
    }

    public void setWordLimit(int wordLimit) {
        this.wordLimit = wordLimit;
    }

    public int getLengthLessThan() {
        return lengthLessThan;
    }

    public void setLengthLessThan(int lengthLessThan) {
        this.lengthLessThan = lengthLessThan;
    }
}
