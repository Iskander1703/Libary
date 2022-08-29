package iskander.tabaev.LibaryRESTApi.controllers;

import iskander.tabaev.LibaryRESTApi.Entity.Book;
import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookApiController {

    private final BookService bookService;


    @Autowired
    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @PostMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createBook(@RequestBody Book book){
        bookService.saveBook(book);

        //Отправляем Http ответ с пустым сообщением с успешным статус кодом
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
