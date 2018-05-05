package com.peteriscaurs.graphqlserver.graphqlserver.services;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.Word;
import com.peteriscaurs.graphqlserver.graphqlserver.domain.FindWordsInput;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class WordService {

    private WordsRepository wordsRepository;

    @Autowired
    public WordService(WordsRepository wordsRepository) {
        this.wordsRepository = wordsRepository;
    }

    public List<Word> findWordsBy(FindWordsInput input) {
        if (input.getPosTag() != null) {
            return wordsRepository.findAll().stream()
                    .filter(word -> word.getHeadword().startsWith(input.getStartsWith().toUpperCase()))
                    .filter(word -> word.getHeadword().endsWith(input.getEndsWith().toUpperCase()))
                    .filter(word -> word.getPosTag().equals(input.getPosTag()))
                    .filter(word -> word.getLength() <= input.getMaxLength())
                    .limit(input.getLimit())
                    .sorted(Comparator.comparingInt(Word::getScore).reversed())
                    .collect(toList());
        } else {
            return wordsRepository.findAll().stream()
                    .filter(word -> word.getHeadword().startsWith(input.getStartsWith().toUpperCase()))
                    .filter(word -> word.getHeadword().endsWith(input.getEndsWith().toUpperCase()))
                    .filter(word -> word.getLength() <= input.getMaxLength())
                    .limit(input.getLimit())
                    .sorted(Comparator.comparingInt(Word::getScore).reversed())
                    .collect(toList());
        }
    }
}
