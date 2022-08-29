package iskander.tabaev.LibaryRESTApi.services;

import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import iskander.tabaev.LibaryRESTApi.repositories.GenreRepository;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> findAll(){
        return genreRepository.findAll();
    }
    public List<Genre> findByGenreName(String name){
        return genreRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    public void saveGenre(Genre genre){
        genreRepository.save(genre);
    }

}
