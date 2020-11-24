package io.github.dreamylost.stream.portfolio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 梦境迷离
 * @version 1.0
 * @since 2020/11/23
 */
@Document
public class User {

    @Id
    private String id;

    private String github;

    private String name;

    public User() {
    }

    public User(String github, String name) {
        this.github = github;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
