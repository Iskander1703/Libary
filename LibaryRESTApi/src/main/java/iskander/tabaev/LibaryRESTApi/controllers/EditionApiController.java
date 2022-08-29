package iskander.tabaev.LibaryRESTApi.controllers;

import iskander.tabaev.LibaryRESTApi.Entity.Edition;
import iskander.tabaev.LibaryRESTApi.dto.EditionDTO;
import iskander.tabaev.LibaryRESTApi.services.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EditionApiController {
    private final EditionService editionService;

    @Autowired
    public EditionApiController(EditionService editionService) {
        this.editionService = editionService;
    }

    @GetMapping("/editions")
    public List<EditionDTO> getAllEditions(@RequestParam(value = "name", required = false) String name){
       return editionService.findByEditionName(name).stream().map(a->convertToEditionDTO(a)).collect(Collectors.toList());
    }

    @PostMapping(value = "/editions", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createEdition(@RequestBody EditionDTO editionDTO){

        editionService.saveEdition(convertToEdition(editionDTO));

        //Отправляем Http ответ с пустым сообщением с успешным статус кодом
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Edition convertToEdition(EditionDTO editionDTO){
        Edition edition=new Edition();
        edition.setName(editionDTO.getName());
        edition.setBooks(editionDTO.getBooks());
        return edition;
    }

    private EditionDTO convertToEditionDTO(Edition edition){
        EditionDTO editionDTO=new EditionDTO();
        editionDTO.setName(edition.getName());
        editionDTO.setBooks(edition.getBooks());
        return editionDTO;
    }
}
