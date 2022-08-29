package iskander.tabaev.LibaryRESTApi.repositories;

import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByNameContainingIgnoreCase(String name);

}