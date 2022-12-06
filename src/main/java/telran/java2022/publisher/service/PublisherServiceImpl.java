package telran.java2022.publisher.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import telran.java2022.publisher.dao.PublisherRepository;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
	final PublisherRepository publisherRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<String> findPublishersByAuthor(String authorName) {
		return publisherRepository.streamByBooksAuthorsNameContains(authorName)
				.map(p -> p.getName())
				.toList();
	}
}
