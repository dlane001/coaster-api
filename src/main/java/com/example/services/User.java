package com.example.services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    @OneToMany(mappedBy = "user")
    private Set<Bookmark> bookmarks = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;
    
    private String username;
    
    private String facebookId;

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    public User(String facebookId) {
        this.facebookId = facebookId;
        this.username = facebookId;
    }

    User() { // jpa only
    }
}