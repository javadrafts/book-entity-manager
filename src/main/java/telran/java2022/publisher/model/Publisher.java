package telran.java2022.publisher.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.java2022.book.model.Book;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "name")
@NoArgsConstructor
public class Publisher implements Serializable {
	private static final long serialVersionUID = 5083976659882404642L;

	@Id
	String name;

	@OneToMany(mappedBy = "publisher")
	Set<Book> books;

	public Publisher(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
