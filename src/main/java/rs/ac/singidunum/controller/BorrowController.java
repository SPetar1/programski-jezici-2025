package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Borrow;
import rs.ac.singidunum.service.BorrowService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/borrow")
@CrossOrigin
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService service;

    @GetMapping
    public List<Borrow> getBorrows() { return service.getBorrows(); }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getBorrowById(id));
    }

    @PostMapping
    public Borrow createBorrow(@RequestBody Borrow model) {
        return service.createBorrow(model);
    }

    @PostMapping(path = "/{id}")
    public Borrow editBorrow(@PathVariable Integer id, @RequestBody Borrow model) {
        return service.editBorrow(id, model);
    }

    @PutMapping(path = "/{id}/return")
    public Borrow returnBorrow(@PathVariable Integer id) {
        return service.returnBorrow(id);
    }
}
