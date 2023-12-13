package C.controllers;

import C.services.InvoiceItemService.InvoiceItemService;
import C.entities.dtoEntitie.InvoiceItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoiceItem")
public class InvoiceItemController {
    private final InvoiceItemService invoiceItemService;

    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceItemDto>> getAll() {
        List<InvoiceItemDto> values = invoiceItemService.getAll();
        return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItemDto> getById(@PathVariable("id") Long id) {
        InvoiceItemDto value = invoiceItemService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody InvoiceItemDto entity) {
        invoiceItemService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping()
    public ResponseEntity<InvoiceItemDto> update(@RequestBody InvoiceItemDto entity) {
        invoiceItemService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InvoiceItemDto> delete(@PathVariable("id") Long id) {
        invoiceItemService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
