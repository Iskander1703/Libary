package iskander.tabaev.LibaryRESTApi.dto;

import iskander.tabaev.LibaryRESTApi.Entity.Book;

import javax.persistence.*;
import java.util.List;

public class GenreDTO {


    public String name;

    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
