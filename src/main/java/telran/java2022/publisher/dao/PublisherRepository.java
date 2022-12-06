package telran.java2022.publisher.dao;

import java.util.Optional;
import java.util.stream.Stream;

import telran.java2022.publisher.model.Publisher;

public interface PublisherRepository {
	Stream<Publisher> streamByBooksAuthorsNameContains(String authorName);

	Optional<Publisher> findById(String publisherName);
}
