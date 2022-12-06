package telran.java2022.publisher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.publisher.service.PublisherService;

@RestController
@RequiredArgsConstructor
public class PublisherController {
	final PublisherService publisherService;

	@GetMapping("publishers/author/{authorName}")
	public Iterable<String> findPublishersByAuthor(@PathVariable String authorName) {
		return publisherService.findPublishersByAuthor(authorName);
	}
}
