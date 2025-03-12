package com.example.appspringdata.repository;

import com.example.appspringdata.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, String> {
}
