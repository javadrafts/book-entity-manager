package telran.java2022.publisher.dao;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.TypedQuery;
import telran.java2022.publisher.model.Publisher;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager entityManager;

	@Override
	public Stream<Publisher> streamByBooksAuthorsNameContains(String authorName) {
		TypedQuery<Publisher> publisherQuery = entityManager
				.createQuery("select p from Publisher p join p.books b join b.authors a where a.name = ?1", Publisher.class);

		publisherQuery.setParameter(1, authorName);

		return publisherQuery.getResultStream();
	}

	@Override
	public Optional<Publisher> findById(String publisherName) {
		Publisher publisher = entityManager.find(Publisher.class, publisherName);

		return Optional.ofNullable(publisher);
	}
}
