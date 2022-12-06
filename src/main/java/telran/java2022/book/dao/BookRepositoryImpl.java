package telran.java2022.book.dao;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.TypedQuery;
import telran.java2022.book.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager entityManager;

	@Override
	public Stream<Book> streamByAuthorsNameContains(String authorName) {
		TypedQuery<Book> bookQuery = entityManager
				.createQuery("select b from Book b join b.authors a where a.name = ?1", Book.class);

		bookQuery.setParameter(1, authorName);

		return bookQuery.getResultStream();
	}

	@Override
	public Stream<Book> streamByPublisherName(String publisherName) {
		TypedQuery<Book> bookQuery = entityManager
				.createQuery("select b from Book b where b.publisher.name = ?1", Book.class);

		bookQuery.setParameter(1, publisherName);

		return bookQuery.getResultStream();
	}

	@Override
	public void delete(Book book) {
		entityManager.remove(book);
	}

	@Override
	public boolean existsById(String isbn) {
		return entityManager.find(Book.class, isbn) != null;
	}

	@Override
	public Book save(Book book) {
		entityManager.persist(book);

		return book;
	}

	@Override
	public Optional<Book> findById(String isbn) {
		Book book = entityManager.find(Book.class, isbn);

		return Optional.ofNullable(book);
	}
}
