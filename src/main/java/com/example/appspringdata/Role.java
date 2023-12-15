package com.example.appspringdata;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Role {
    @RelationshipId
    private Long id;

    private String role;

    @TargetNode
    private final Person person;

    public Role(Long id, String role, Person person) {
        this.id = id;
        this.role = role;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }
}
