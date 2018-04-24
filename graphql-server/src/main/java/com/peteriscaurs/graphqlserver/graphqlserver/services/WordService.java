package com.peteriscaurs.graphqlserver.graphqlserver.services;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.Word;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.WordInput;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author peteris-caurs
 */
@Component
public class WordService {

    private WordsRepository wordsRepository;

    @Autowired
    public WordService(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    public List<Word> getAllWords() {
        return wordsRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Word::getScore).reversed())
                .collect(toList());
    }

    public List<Word> getSpecifiedWords(WordInput params) {
        return wordsRepository.findAll().stream()
                .filter(word -> word.getHeadword().startsWith(params.getStartsWith().toUpperCase()))
                .filter(word -> word.getHeadword().endsWith(params.getEndsWith().toUpperCase()))
                .filter(word -> word.getLength() < params.getLengthLessThan())
                .limit(params.getWordLimit())
                .sorted(Comparator.comparingInt(Word::getScore).reversed())
                .collect(toList());
    }

}
