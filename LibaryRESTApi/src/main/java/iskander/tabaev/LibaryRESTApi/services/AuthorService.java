package iskander.tabaev.LibaryRESTApi.services;

import iskander.tabaev.LibaryRESTApi.Entity.Author;
import iskander.tabaev.LibaryRESTApi.repositories.AuthorRepository;
import iskander.tabaev.LibaryRESTApi.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<Author> findByAuthorNameOrSurnameOrPatronymic(String name, String surname, String patronymic) {
        if (name == null) {
            return authorRepository.findAll();
        } else {
            Optional<List<Author>> optionalAuthors = authorRepository.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrPantronymicContainingIgnoreCase(name, surname, patronymic);
            if (optionalAuthors.get().size() == 0) {
                throw new NotFoundException("Автор не найден");
            }
            return optionalAuthors.get();
        }
    }

    @Transactional
    public void saveAuthor(Author author){
        authorRepository.save(author);
    }
}

