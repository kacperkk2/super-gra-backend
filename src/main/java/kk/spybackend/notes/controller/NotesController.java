package kk.spybackend.notes.controller;

import kk.spybackend.notes.model.NoteDto;
import kk.spybackend.notes.model.NotesDto;
import kk.spybackend.notes.service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://kacperkk2.github.io"})
public class NotesController {

    private final NotesService notesService;

    @GetMapping()
    public ResponseEntity<List<NoteDto>> get() {
        return ResponseEntity.ok().body(notesService.get());
    }

//    @GetMapping("/{name}")
//    @CrossOrigin
//    public ResponseEntity<NoteDto> load(@PathVariable String name) {
//        try {
//            return ResponseEntity.ok().body(notesService.load(name));
//        } catch (NotesNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping()
//    @CrossOrigin
//    public ResponseEntity<List<NoteDto>> loadAll() {
//        return ResponseEntity.ok().body(notesService.loadAll());
//    }
//
//    @GetMapping("/default")
//    @CrossOrigin
//    public String loadDefault() {
//        return notesService.loadDefault();
//    }
//
//    @DeleteMapping("/{name}")
//    @CrossOrigin
//    public void delete(@PathVariable String name) {
//        notesService.delete(name);
//    }
}
