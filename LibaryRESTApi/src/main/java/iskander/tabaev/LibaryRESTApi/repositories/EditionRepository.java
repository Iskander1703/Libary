package iskander.tabaev.LibaryRESTApi.repositories;

import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Integer> {

   Optional<List<Edition> > findByNameContainingIgnoreCase(String name);

   @Query("SELECT e FROM Edition e WHERE e.id=1")
   Optional<List<Edition> > findMyEdition(String name);
}
