package iskander.tabaev.LibaryRESTApi.controllers;

import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import iskander.tabaev.LibaryRESTApi.dto.EditionDTO;
import iskander.tabaev.LibaryRESTApi.dto.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import iskander.tabaev.LibaryRESTApi.services.GenreService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GenreApiController {

    private final GenreService genreService;

    @Autowired
    public GenreApiController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres")
    public List<GenreDTO> getAllGenres(@RequestParam(value = "name", required = false) String name) {
        return genreService.findByGenreName(name).stream().map(a->convertToGenreDTO(a)).collect(Collectors.toList());
    }

    @PostMapping("/genres")
    public ResponseEntity<HttpStatus> createGenre(@RequestBody GenreDTO genreDTO){
       genreService.saveGenre(convertToGenre(genreDTO));

        //Отправляем Http ответ с пустым сообщением с успешным статус кодом
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Genre convertToGenre(GenreDTO genreDTO){
        Genre genre=new Genre();
        genre.setName(genreDTO.getName());
        genre.setBooks(genreDTO.getBooks());
        return genre;
    }

    private GenreDTO convertToGenreDTO(Genre genre){
        GenreDTO genreDTO=new GenreDTO();
        genreDTO.setName(genre.getName());
        genreDTO.setBooks(genre.getBooks());
        return genreDTO;
    }

}
