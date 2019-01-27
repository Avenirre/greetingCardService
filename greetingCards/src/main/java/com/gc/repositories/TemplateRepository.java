package com.gc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gc.model.Template;

public interface TemplateRepository extends MongoRepository<Template, String> {

}
