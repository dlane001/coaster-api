package com.example.services;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByUserFacebookId(String username);
}
