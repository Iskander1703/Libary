package iskander.tabaev.LibaryRESTApi.controllers;

import iskander.tabaev.LibaryRESTApi.Entity.Author;
import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import iskander.tabaev.LibaryRESTApi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthorApiController {
    private final AuthorService authorService;

    @Autowired
    public AuthorApiController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> findAuthors(@RequestParam(value = "name", required = false) String name){
        return authorService.findByAuthorNameOrSurnameOrPatronymic(name, name, name);
    }

    @PostMapping("/authors")
    public ResponseEntity<HttpStatus> createGenre(@RequestBody Author author){
        authorService.saveAuthor(author);

        //Отправляем Http ответ с пустым сообщением с успешным статус кодом
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
