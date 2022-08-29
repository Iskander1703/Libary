package iskander.tabaev.LibaryRESTApi.controllers;

import iskander.tabaev.LibaryRESTApi.Entity.Book;
import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.dto.BookDTO;
import iskander.tabaev.LibaryRESTApi.dto.EditionDTO;
import iskander.tabaev.LibaryRESTApi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookApiController {

    private final BookService bookService;


    @Autowired
    public BookApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks(){
        return bookService.findAll().stream().map(a->convertToBookDTO(a)).collect(Collectors.toList());
    }

    @PostMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createBook(@RequestBody BookDTO bookDTO){
        bookService.saveBook(convertToBook(bookDTO));

        //Отправляем Http ответ с пустым сообщением с успешным статус кодом
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Book convertToBook(BookDTO bookDTO){
       Book book=new Book();
       book.setDateOfTaken(bookDTO.getDateOfTaken());
       book.setAuthors(bookDTO.getAuthors());
       book.setDateOfReturn(bookDTO.getDateOfReturn());
       book.setBinding(bookDTO.getBinding());
       book.setYearOfManufacture(bookDTO.getYearOfManufacture());
       book.setEdition(bookDTO.getEdition());
       book.setGenres(bookDTO.getGenres());
       book.setName(bookDTO.getName());
        return book;
    }

    private BookDTO convertToBookDTO(Book book){
        BookDTO bookDTO=new BookDTO();
        bookDTO.setDateOfTaken(book.getDateOfTaken());
        bookDTO.setAuthors(book.getAuthors());
        bookDTO.setDateOfReturn(book.getDateOfReturn());
        bookDTO.setBinding(book.getBinding());
        bookDTO.setYearOfManufacture(book.getYearOfManufacture());
        bookDTO.setEdition(book.getEdition());
        bookDTO.setGenres(book.getGenres());
        bookDTO.setName(book.getName());
        return bookDTO;
    }
}
