package dev.christianfelix.contentcalendar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

	@GetMapping("/{id}")
	public Content findById(@PathVariable Integer id) {
		return repository
				.findById(id)
				.orElseThrow(
						() -> new ResponseStatusException(
								HttpStatus.NOT_FOUND,
								"Content not found!"));
	}
	
	@PostMapping("")
	public void create(Content content) {
		repository.save(content);
	}

}
