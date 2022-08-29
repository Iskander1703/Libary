package iskander.tabaev.LibaryRESTApi.controllers;

import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import iskander.tabaev.LibaryRESTApi.services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreApiController {

    private final GenreService genreService;

    @Autowired
    public GenreApiController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenres(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return genreService.findAll();
        }
        else{
            return genreService.findByGenreName(name);
        }
    }

    @PostMapping("/genres")
    public ResponseEntity<HttpStatus> createGenre(@RequestBody Genre genre){
        genreService.saveGenre(genre);

        //Отправляем Http ответ с пустым сообщением с успешным статус кодом
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
