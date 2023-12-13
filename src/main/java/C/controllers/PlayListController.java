package C.controllers;

import C.entities.dtoEntitie.PlaylistDto;
import C.services.PlayListService.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platList")
public class PlayListController {
    private final PlayListService playListService;

    public PlayListController(PlayListService playListService) {
        this.playListService = playListService;
    }
    @GetMapping
    public ResponseEntity<List<PlaylistDto>> getAll() {
        List<PlaylistDto> values = playListService.getAll();
        return ResponseEntity.ok(values);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDto> getById(@PathVariable("id") Long id) {
        PlaylistDto value = playListService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody PlaylistDto entity) {
        playListService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping()
    public ResponseEntity<PlaylistDto> update(@RequestBody PlaylistDto entity) {
        playListService.update(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlaylistDto> delete(@PathVariable("id") Long id) {
        playListService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
