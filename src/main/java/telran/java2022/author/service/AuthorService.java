package telran.java2022.author.service;

import telran.java2022.author.dto.AuthorDto;

public interface AuthorService {
	AuthorDto removeAuthor(String name);

	Iterable<AuthorDto> findAuthorsByBook(String bookIsbn);
}
