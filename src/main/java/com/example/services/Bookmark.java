package com.example.services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bookmark {

    @JsonIgnore
    @ManyToOne
    private User user;

    @Id
    @GeneratedValue
    private Long id;

    Bookmark() { // jpa only
    }

    public Bookmark(User user, String uri, String description) {
        this.uri = uri;
        this.description = description;
        this.user = user;
    }

    public String uri;
    public String description;

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getDescription() {
        return description;
    }
}