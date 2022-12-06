package telran.java2022.author.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import telran.java2022.author.dao.AuthorRepository;
import telran.java2022.author.dto.AuthorDto;
import telran.java2022.author.dto.exceptions.AuthorNotFoundException;
import telran.java2022.author.model.Author;
import telran.java2022.book.dao.BookRepository;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
	final AuthorRepository authorRepository;

	final BookRepository bookRepository;

	final ModelMapper modelMapper;

	@Override
	public AuthorDto removeAuthor(String name) {
		Author author = authorRepository.findById(name)
				.orElseThrow(AuthorNotFoundException::new);

		author.getBooks().stream()
				.forEach(b -> b.getAuthors().remove(author));

		author.getBooks().stream()
				.filter(b -> b.getAuthors().size() == 0)
				.forEach(bookRepository::delete);

		authorRepository.delete(author);

		return modelMapper.map(author, AuthorDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<AuthorDto> findAuthorsByBook(String bookIsbn) {
		return authorRepository.streamByBooksIsbn(bookIsbn)
				.map(a -> modelMapper.map(a, AuthorDto.class))
				.toList();
	}
}
