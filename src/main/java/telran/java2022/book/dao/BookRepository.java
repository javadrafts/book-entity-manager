package telran.java2022.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import telran.java2022.book.model.Book;

public interface BookRepository {
	Stream<Book> streamByAuthorsNameContains(String authorName);

	Stream<Book> streamByPublisherName(String publisherName);

	void delete(Book book);

	boolean existsById(String isbn);

	Book save(Book book);

	Optional<Book> findById(String isbn);
}
