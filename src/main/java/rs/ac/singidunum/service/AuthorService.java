package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Author;
import rs.ac.singidunum.repo.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Optional<Author> getAuthorById(Integer id) {
        return repository.findById(id);
    }

    public Author createAuthor(Author model) {
        Author author = new Author();
        author.setFirstName(model.getFirstName());
        author.setLastName(model.getFirstName());
        return repository.save(author);
    }

    public Author editAuthor(Integer id, Author model) {
        Author author = getAuthorById(id).orElseThrow();

        author.setFirstName(model.getFirstName());
        author.setLastName(model.getLastName());
        return repository.save(author);
    }
}
