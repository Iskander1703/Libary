package iskander.tabaev.LibaryRESTApi.repositories;

import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Integer> {


//    @Query("SELECT e FROM Edition e LEFT JOIN e.books b LEFT  JOIN b.authors LEFT join b.genres  " +
//            "left join b.authors where lower(e.name) like lower(concat('%', :edition, '%')) ")
//    Optional<List<Edition>> findByNameContainingIgnoreCaseMy(@Param("edition") String name);
//
//    @Query("SELECT e FROM Edition e LEFT join e.books b left join b.authors left join b.genres")
//    Optional<List<Edition>> findAllMy();

    Optional<List<Edition>> findByNameContainingIgnoreCase( String name);
}
