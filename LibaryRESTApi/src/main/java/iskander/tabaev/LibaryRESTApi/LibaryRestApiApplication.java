package iskander.tabaev.LibaryRESTApi;

import iskander.tabaev.LibaryRESTApi.repositories.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class LibaryRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibaryRestApiApplication.class, args);

    }

}
