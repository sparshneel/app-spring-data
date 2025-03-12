package com.example.appspringdata.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Node
public class Person {

    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator.class)
    private String id;
    private Date born;
    private String bornIn;
    private String tmdbId;
    private String bio;
    private Date died;
    private String name;
    private String poster;
    private String imdbId;
    private String url;
}
