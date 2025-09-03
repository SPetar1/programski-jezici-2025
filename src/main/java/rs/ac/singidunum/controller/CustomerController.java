package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getCustomerById(id));
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer model) {
        return service.createCustomer(model);
    }

    @PostMapping(path = "/{id}")
    public Customer editCustomer(@PathVariable Integer id, @RequestBody Customer model) {
        return service.editCustomer(id, model);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.deleteCustomer(id);
    }
}
