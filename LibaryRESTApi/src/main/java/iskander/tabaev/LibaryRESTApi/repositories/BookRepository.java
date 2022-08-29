package iskander.tabaev.LibaryRESTApi.repositories;

import iskander.tabaev.LibaryRESTApi.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
