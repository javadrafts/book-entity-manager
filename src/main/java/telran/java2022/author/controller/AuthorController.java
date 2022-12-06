package telran.java2022.author.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java2022.author.dto.AuthorDto;
import telran.java2022.author.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {
	final AuthorService authorService;

	@DeleteMapping("author/{name}")
	public AuthorDto removeAuthor(@PathVariable String name) {
		return authorService.removeAuthor(name);
	}

	@GetMapping("authors/book/{bookIsbn}")
	public Iterable<AuthorDto> findAuthorsByBook(@PathVariable String bookIsbn) {
		return authorService.findAuthorsByBook(bookIsbn);
	}
}
