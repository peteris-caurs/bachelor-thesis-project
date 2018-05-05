package com.peteriscaurs.graphqlserver.graphqlserver.utilities;

import java.util.HashMap;
import java.util.Map;

public final class WordEligabilityChecker {

    private WordEligabilityChecker() { }

    public static boolean isEligable(String word) {
        Map<Character, Integer> charIntMap = new HashMap<Character, Integer>();
        word = word.toUpperCase();
        for (int i = 0; i < word.length(); ++i) {
            char charAt = word.charAt(i);
            if (!charIntMap.containsKey(charAt)) {
                charIntMap.put(charAt, 1);
            } else {
                charIntMap.put(charAt, charIntMap.get(charAt) + 1);
            }
        }


        return charIntMap.entrySet().stream()
                .noneMatch(e -> getAllowedLetterAmount(e.getKey()) < e.getValue());

    }


    private static int getAllowedLetterAmount(char letter) {
        switch (letter) {
            case 'A': return 11;
            case 'I': return 9;
            case 'S': return 8;
            case 'T': case 'E': return 6;
            case 'R': case 'U': return 5;
            case 'Ā': case 'K': case 'M': case 'N': return 4;
            case 'V': case 'D': case 'L': case 'O': case 'P': return 3;
            case 'Ē': case 'Ī': case 'J': case 'Z': return 2;
            default: return 1;
        }
    }

}
