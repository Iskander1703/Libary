package iskander.tabaev.LibaryRESTApi.services;

import iskander.tabaev.LibaryRESTApi.Entity.Book;
import iskander.tabaev.LibaryRESTApi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return  bookRepository.findAll();
    }

    @Transactional
    public void saveBook(Book book){
        bookRepository.save(book);
    }
}
