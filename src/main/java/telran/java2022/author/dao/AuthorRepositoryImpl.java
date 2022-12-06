package telran.java2022.author.dao;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.TypedQuery;
import telran.java2022.author.model.Author;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager entityManager;

	@Override
	public Optional<Author> findById(String name) {
		Author author = entityManager.find(Author.class, name);

		return Optional.ofNullable(author);
	}

	@Override
	public Stream<Author> streamByBooksIsbn(String isbn) {
		TypedQuery<Author> authorQuery = entityManager
				.createQuery("select a from Author a join a.books b where b.isbn = ?1", Author.class);

		authorQuery.setParameter(1, isbn);

		return authorQuery.getResultStream();
	}

	@Override
	public void delete(Author author) {
		entityManager.remove(author);
	}
}
