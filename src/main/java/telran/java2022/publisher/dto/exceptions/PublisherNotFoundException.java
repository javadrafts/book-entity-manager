package telran.java2022.publisher.dto.exceptions;

public class PublisherNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5898197756349209871L;

	public PublisherNotFoundException() {
		super("Publisher not found.");
	}
}
