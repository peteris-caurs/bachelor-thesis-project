package com.peteriscaurs.graphqlserver.graphqlserver.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "words")
public class Word {

    @Id private String id;
    private String headword;
    private PosTag posTag;
    private String sources;
    private int score;
    private int length;

    public Word(
            String id,
            String headword,
            PosTag posTag,
            String sources,
            int score,
            int length
    ) {
        this.id = id;
        this.headword = headword;
        this.posTag = posTag;
        this.sources = sources;
        this.score = score;
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadword() {
        return headword;
    }

    public void setHeadword(String headword) {
        this.headword = headword;
    }

    public PosTag getPosTag() {
        return posTag;
    }

    public void setPosTag(PosTag posTag) {
        this.posTag = posTag;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id='" + id + '\'' +
                ", headword='" + headword + '\'' +
                ", posTag=" + posTag +
                ", sources='" + sources + '\'' +
                ", score=" + score +
                ", length=" + length +
                '}';
    }

}
