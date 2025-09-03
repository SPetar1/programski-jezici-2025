package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByDeletedAtIsNull();
    Optional<Book> findByIdAndDeletedAtIsNull(Integer id);
}
