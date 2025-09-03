package rs.ac.singidunum.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Book;
import rs.ac.singidunum.service.BookService;
import java.util.List;

@RestController
@RequestMapping(path = "/api/book")
@CrossOrigin
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getBookById(id));
    }

    @PostMapping
    public Book createBook(@RequestBody Book model) { return service.createBook(model); }

    @PostMapping(path = "/{id}")
    public Book editBook(@PathVariable Integer id, @RequestBody Book model){
        return service.editBook(id, model);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBook(@PathVariable Integer id) { service.deleteBook(id);}
}