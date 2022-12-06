package telran.java2022.publisher.service;

public interface PublisherService {
	Iterable<String> findPublishersByAuthor(String authorName);
}
