package iskander.tabaev.LibaryRESTApi.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String pantronymic;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author(int id, String name, String surname, String pantronymic, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pantronymic = pantronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public Author(int id, String name, String surname, String pantronymic, Date dateOfBirth, List<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pantronymic = pantronymic;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }

    public Author(String name, String surname, String pantronymic, Date dateOfBirth, List<Book> books) {
        this.name = name;
        this.surname = surname;
        this.pantronymic = pantronymic;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }

    public Author(String name, String surname, String pantronymic, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.pantronymic = pantronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public Author() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPantronymic() {
        return pantronymic;
    }

    public void setPantronymic(String pantronymic) {
        this.pantronymic = pantronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

