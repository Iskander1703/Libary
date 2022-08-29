package iskander.tabaev.LibaryRESTApi.services;

import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import iskander.tabaev.LibaryRESTApi.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import iskander.tabaev.LibaryRESTApi.repositories.GenreRepository;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findByGenreName(String name){
        if (name == null) {
            return genreRepository.findAll();
        } else {
            Optional<List<Genre>> optionalGenres = genreRepository.findByNameContainingIgnoreCase(name);
            if (optionalGenres.get().size() == 0) {
                throw new NotFoundException("Жанр не найден");
            }
            return optionalGenres.get();
        }
    }

    @Transactional
    public void saveGenre(Genre genre){
        enrichGenre(genre);
        genreRepository.save(genre);
    }

    private void enrichGenre(Genre genre){
        genre.setBooks(null);
    }

}
