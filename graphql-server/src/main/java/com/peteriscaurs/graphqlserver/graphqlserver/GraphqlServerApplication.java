package com.peteriscaurs.graphqlserver.graphqlserver;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.Word;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.WordsRepository;
import com.peteriscaurs.graphqlserver.graphqlserver.utilities.WordEligabilityChecker;
import com.peteriscaurs.graphqlserver.graphqlserver.utilities.WordScoreCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@SpringBootApplication
public class GraphqlServerApplication implements CommandLineRunner {

	@Autowired
	private WordsRepository wordsRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlServerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		List<Word> words = wordsRepository.findAll();

		List<Word> updatedWords = words.stream()
				.map(word ->
						new Word(
								word.getId(),
								word.getHeadword().toUpperCase(),
								word.getPosTag(),
								word.getSources(),
								WordScoreCalculator.calculateWordScore(word.getHeadword()),
								word.getHeadword().length())
				)
				.filter(word -> WordEligabilityChecker.isEligable(word.getHeadword()))
				.filter(word -> word.getLength() <= 15)
				.collect(toList());

		updatedWords.forEach(System.out::println);
	}

}
