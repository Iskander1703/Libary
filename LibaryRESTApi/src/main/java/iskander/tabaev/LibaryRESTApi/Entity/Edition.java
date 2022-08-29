package iskander.tabaev.LibaryRESTApi.Entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "editions")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edition_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "edition")
    private List<Book> books;

    public Edition(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public Edition() {
    }

    public Edition(int id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Edition(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Edition(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
