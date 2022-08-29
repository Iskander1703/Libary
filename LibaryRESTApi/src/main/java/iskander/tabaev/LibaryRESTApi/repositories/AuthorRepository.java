package iskander.tabaev.LibaryRESTApi.repositories;

import iskander.tabaev.LibaryRESTApi.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public Optional<List<Author>> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrPantronymicContainingIgnoreCase(String name, String surname, String patronymic);
}
