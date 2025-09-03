package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Author;
import rs.ac.singidunum.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/author")
@CrossOrigin
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @GetMapping
    public List<Author> getAuthors() {
        return service.getAuthors();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getAuthorById(id));
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author model) {
        return service.createAuthor(model);
    }

    @PostMapping(path = "/{id}")
    public Author editAuthor(@PathVariable Integer id, @RequestBody Author model) {
        return service.editAuthor(id, model);
    }
}
