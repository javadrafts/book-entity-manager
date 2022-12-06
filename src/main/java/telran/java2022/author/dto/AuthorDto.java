package telran.java2022.author.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
	String name;

	LocalDate birthDate;
}
