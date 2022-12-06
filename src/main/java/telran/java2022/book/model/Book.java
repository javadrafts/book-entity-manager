package telran.java2022.book.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import telran.java2022.author.model.Author;
import telran.java2022.publisher.model.Publisher;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "isbn")
public class Book implements Serializable {
	private static final long serialVersionUID = -7524871870001501031L;

	@Id
	String isbn;

	String title;

	@ManyToMany(cascade = CascadeType.ALL)
	Set<Author> authors;

	@ManyToOne(cascade = CascadeType.ALL)
	Publisher publisher;
}
