package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Author;
import rs.ac.singidunum.entity.Book;
import rs.ac.singidunum.repo.BookRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Book> getBookById(Integer id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }

    public Book createBook(Book model) {
        Book book = new Book();

        book.setTitle(model.getTitle());
        book.setDescription(model.getDescription());
        book.setPublishingYear(model.getPublishingYear());
        book.setCount(model.getCount());

        Author author = new Author();
        author.setId(model.getAuthor().getId());
        book.setAuthor(author);

        return repository.save(book);
    }

    public Book editBook(Integer id, Book model) {
        Book book = getBookById(id).orElseThrow();

        book.setTitle(model.getTitle());
        book.setDescription(model.getDescription());
        book.setPublishingYear(model.getPublishingYear());
        book.setCount(model.getCount());

        Author author = new Author();
        author.setId(model.getAuthor().getId());
        book.setAuthor(author);

        return repository.save(book);
    }

    public void deleteBook(Integer id) {
        Book book = getBookById(id).orElseThrow();
        book.setDeletedAt(LocalDateTime.now());
        repository.save(book);
    }
}
