package com.example.appspringdata.domain;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Role {

    @RelationshipId
    private String id;

    private String role;

    @TargetNode
    private Person person;
}
