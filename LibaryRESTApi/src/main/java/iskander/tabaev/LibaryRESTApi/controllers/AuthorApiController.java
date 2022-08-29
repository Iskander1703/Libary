package iskander.tabaev.LibaryRESTApi.controllers;

import iskander.tabaev.LibaryRESTApi.Entity.Author;
import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import iskander.tabaev.LibaryRESTApi.dto.AuthorDTO;
import iskander.tabaev.LibaryRESTApi.dto.EditionDTO;
import iskander.tabaev.LibaryRESTApi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AuthorApiController {
    private final AuthorService authorService;

    @Autowired
    public AuthorApiController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<AuthorDTO> findAuthors(@RequestParam(value = "name", required = false) String name) {
        return authorService.findByAuthorNameOrSurnameOrPatronymic(name, name, name).stream().map(a->convertToAuthorDTO(a)).collect(Collectors.toList());
    }

    @PostMapping("/authors")
    public ResponseEntity<HttpStatus> createGenre(@RequestBody AuthorDTO authorDTO) {
        authorService.saveAuthor(convertToAuthor(authorDTO));

        //Отправляем Http ответ с пустым сообщением с успешным статус кодом
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private AuthorDTO convertToAuthorDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName(author.getName());
        authorDTO.setSurname(author.getSurname());
        authorDTO.setPantronymic(author.getPantronymic());
        authorDTO.setBooks(author.getBooks());
        authorDTO.setDateOfBirth(author.getDateOfBirth());
        return authorDTO;
    }

    private Author convertToAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setPantronymic(authorDTO.getPantronymic());
        author.setBooks(authorDTO.getBooks());
        author.setDateOfBirth(authorDTO.getDateOfBirth());
        return author;
    }


}
