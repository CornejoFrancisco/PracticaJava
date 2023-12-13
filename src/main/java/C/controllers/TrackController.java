package C.controllers;

import C.entities.dtoEntitie.TrackDto;
import C.services.CustomerService.CustomerService;
import C.services.TrackService.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/track")
public class TrackController {
    private final TrackService trackService;
    private final CustomerService customerService;
    public TrackController(CustomerService customerService, TrackService trackService) {
        this.trackService = trackService;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<TrackDto>> getAll() {
        List<TrackDto> values = trackService.getAll();
        return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TrackDto> getById(@PathVariable("id") Long id) {
        TrackDto value = trackService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody TrackDto entity) {
        trackService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping()
    public ResponseEntity<TrackDto> update(@RequestBody TrackDto entity) {
        trackService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrackDto> delete(@PathVariable("id") Long id) {
        trackService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
