package rs.ac.singidunum.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Book;
import rs.ac.singidunum.entity.Borrow;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.repo.BorrowRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowService {
    private final BorrowRepository repository;

    public List<Borrow> getBorrows() { return repository.findAll(); }

    public Optional<Borrow> getBorrowById(Integer id) { return repository.findById(id); }

    public Borrow createBorrow(Borrow model) {
        Borrow borrow = new Borrow();

        Customer customer = new Customer();
        customer.setId(model.getCustomer().getId());
        borrow.setCustomer(customer);

        Book book = new Book();
        book.setId(model.getBook().getId());
        borrow.setBook(book);

        borrow.setBorrowedAt(LocalDateTime.now());
        borrow.setReturnAt(LocalDateTime.now().plusDays(30));

        return repository.save(borrow);
    }

    public Borrow editBorrow(Integer id, Borrow model) {
        Borrow borrow = getBorrowById(id).orElseThrow();

        Customer customer = new Customer();
        customer.setId(model.getCustomer().getId());
        borrow.setCustomer(customer);

        Book book = new Book();
        book.setId(model.getBook().getId());
        borrow.setBook(book);

        borrow.setReturnAt(model.getReturnAt());
        borrow.setReturnedAt(model.getReturnedAt());

        return repository.save(borrow);
    }

    public Borrow returnBorrow(Integer id) {
        Borrow borrow = getBorrowById(id).orElseThrow();
        borrow.setReturnedAt(LocalDateTime.now());
        return repository.save(borrow);
    }
}
