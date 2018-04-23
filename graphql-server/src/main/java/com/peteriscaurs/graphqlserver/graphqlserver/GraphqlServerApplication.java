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
public class GraphqlServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlServerApplication.class, args);
	}

}
