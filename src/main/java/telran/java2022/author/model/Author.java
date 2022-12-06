package telran.java2022.author.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import telran.java2022.book.model.Book;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "name")
public class Author implements Serializable {
	private static final long serialVersionUID = 5062660848685351278L;

	@Id
	String name;

	LocalDate birthDate;

	@ManyToMany(mappedBy = "authors")
	Set<Book> books;
}
