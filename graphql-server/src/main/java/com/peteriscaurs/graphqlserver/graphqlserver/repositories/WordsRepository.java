package com.peteriscaurs.graphqlserver.graphqlserver.repositories;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.Word;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WordsRepository extends MongoRepository<Word, String> {
}
