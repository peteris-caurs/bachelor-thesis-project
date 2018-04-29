package com.peteriscaurs.graphqlserver.graphqlserver.repositories;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.Word;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author peteris-caurs
 */
public interface WordsRepository extends MongoRepository<Word, String> {
}
