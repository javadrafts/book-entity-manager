package telran.java2022.author.dao;

import java.util.Optional;
import java.util.stream.Stream;

import telran.java2022.author.model.Author;

public interface AuthorRepository {
	Stream<Author> streamByBooksIsbn(String isbn);

	Optional<Author> findById(String name);

	void delete(Author author);
}
