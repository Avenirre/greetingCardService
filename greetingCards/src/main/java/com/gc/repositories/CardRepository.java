package com.gc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gc.model.Card;

public interface CardRepository extends MongoRepository<Card, String> {

}
