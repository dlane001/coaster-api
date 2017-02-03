package com.example.services;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
class BookmarkRestController {

	private final BookmarkRepository bookmarkRepository;

	private final AccountRepository accountRepository;

	@Autowired
	BookmarkRestController(BookmarkRepository bookmarkRepository,
						   AccountRepository accountRepository) {
		this.bookmarkRepository = bookmarkRepository;
		this.accountRepository = accountRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<Bookmark> readBookmarks() {
		Bookmark bookmark = new Bookmark();
		bookmark.description = "Hey whats up";
		Collection<Bookmark> marks = bookmarkRepository.findAll();
		marks.add(bookmark);
		return marks;
	}
}
