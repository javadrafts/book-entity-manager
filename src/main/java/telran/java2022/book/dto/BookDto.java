package telran.java2022.book.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import telran.java2022.author.dto.AuthorDto;

@Getter
@Setter
public class BookDto {
	String isbn;

	String title;

	Set<AuthorDto> authors;

	String publisher;
}
