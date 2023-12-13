package C.controllers;
import C.entities.dtoEntitie.CustomerDto;
import C.services.CustomerService.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<CustomerDto> values = customerService.getAll();
        return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") Long id) {
        CustomerDto value = customerService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CustomerDto entity) {
        customerService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping()
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto entity) {
        customerService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> delete(@PathVariable("id") Long id) {
        customerService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}