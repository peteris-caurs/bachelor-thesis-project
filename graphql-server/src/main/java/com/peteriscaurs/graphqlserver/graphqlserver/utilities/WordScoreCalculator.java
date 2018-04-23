package com.peteriscaurs.graphqlserver.graphqlserver.utilities;

/**
 * @author peteris-caurs
 */
public final class WordScoreCalculator {

    private WordScoreCalculator() { }

    public static int calculateWordScore(String word) {
        word = word.toUpperCase();
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            score += getLetterScore(word.charAt(i));
        }
        return score;
    }

    private static int getLetterScore(char letter) {
        switch (letter) {
            case 'Č': case 'F': case 'Ģ': case 'H': case 'Ķ': return 10;
            case 'Ļ': case 'Ž': return 8;
            case 'Ņ': case 'Š': case 'Ū': return 6;
            case 'B': case 'C': case 'G': return 5;
            case 'Ē': case 'Ī': case 'J': return 4;
            case 'D': case 'O': case 'V': case 'Z': return 3;
            case 'Ā': case 'K': case 'L': case 'M': case 'N': case 'P': return 2;
            default: return 1;
        }
    }

}
