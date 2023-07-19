package dev.christianfelix.contentcalendar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.christianfelix.contentcalendar.model.Content;
import dev.christianfelix.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {

	private final ContentCollectionRepository repository;

	public ContentController(ContentCollectionRepository contentCollectionRepository) {
		this.repository = contentCollectionRepository;
	}
	
	// make a request and find all the pieces of content in the system
	@GetMapping("")
	public List<Content> findAll() {
		return repository.findAll();
	}
	
}
