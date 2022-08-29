package iskander.tabaev.LibaryRESTApi.dto;

import iskander.tabaev.LibaryRESTApi.Entity.Book;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class AuthorDTO {

    private String name;
    private String surname;
    private String pantronymic;
    private Date dateOfBirth;
    private List<Book> books;

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
