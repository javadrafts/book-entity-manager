package telran.java2022.author.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1120698102143557649L;

	public AuthorNotFoundException() {
		super("Author not found.");
	}
}
