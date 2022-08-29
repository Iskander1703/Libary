package iskander.tabaev.LibaryRESTApi.services;

import iskander.tabaev.LibaryRESTApi.Entity.Author;
import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.Entity.Genre;
import iskander.tabaev.LibaryRESTApi.repositories.EditionRepository;
import iskander.tabaev.LibaryRESTApi.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@Service
public class EditionService {

    private final EditionRepository editionRepository;

    @Autowired
    public EditionService(EditionRepository editionRepository) {
        this.editionRepository = editionRepository;
    }

    public List<Edition> findByEditionName(String name) {
        if (name == null) {
            return editionRepository.findAll();
        } else {
            Optional<List<Edition>> optionalEditions = editionRepository.findByNameContainingIgnoreCase(name);
            if (optionalEditions.get().size() == 0) {
                throw new NotFoundException("Издание с названием не найдено");
            }
            return optionalEditions.get();
        }
    }

    @Transactional
    public void saveEdition(Edition edition){
        enrichEdition(edition);
        editionRepository.save(edition);
    }

    private void enrichEdition(Edition edition){
        edition.setBooks(null);
    }
}
