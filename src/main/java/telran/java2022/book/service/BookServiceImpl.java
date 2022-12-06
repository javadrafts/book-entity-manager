package telran.java2022.book.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import telran.java2022.book.dao.BookRepository;
import telran.java2022.book.dto.BookDto;
import telran.java2022.book.dto.exceptions.BookNotFoundException;
import telran.java2022.book.model.Book;
import telran.java2022.publisher.dao.PublisherRepository;
import telran.java2022.publisher.model.Publisher;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	final BookRepository bookRepository;

	final PublisherRepository publisherRepository;

	final ModelMapper modelMapper;

	@Override
	public boolean addBook(BookDto bookDto) {
		if (bookRepository.existsById(bookDto.getIsbn())) {
			return false;
		}

		String publisherName = bookDto.getPublisher();

		Publisher publisher = publisherRepository.findById(publisherName)
				.orElse(new Publisher(publisherName));

		Book book = modelMapper.map(bookDto, Book.class);

		book.setPublisher(publisher);

		bookRepository.save(book);

		return true;
	}

	@Override
	public BookDto findBookByIsbn(String isbn) {
		Book book = bookRepository.findById(isbn)
				.orElseThrow(BookNotFoundException::new);

		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public BookDto removeBook(String isbn) {
		Book book = bookRepository.findById(isbn)
				.orElseThrow(BookNotFoundException::new);

		bookRepository.delete(book);

		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public BookDto updateBookTitle(String isbn, String title) {
		Book book = bookRepository.findById(isbn)
				.orElseThrow(BookNotFoundException::new);

		book.setTitle(title);

		book = bookRepository.save(book);

		return modelMapper.map(book, BookDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<BookDto> findBooksByAuthor(String authorName) {
		return bookRepository.streamByAuthorsNameContains(authorName)
				.map(b -> modelMapper.map(b, BookDto.class))
				.toList();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<BookDto> findBooksByPublisher(String publisherName) {
		return bookRepository.streamByPublisherName(publisherName)
				.map(b -> modelMapper.map(b, BookDto.class))
				.toList();
	}
}
