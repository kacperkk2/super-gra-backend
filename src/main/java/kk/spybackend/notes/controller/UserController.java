package kk.spybackend.notes.controller;

import kk.spybackend.notes.exceptions.UsersException;
import kk.spybackend.notes.model.NotesDto;
import kk.spybackend.notes.model.UserDto;
import kk.spybackend.notes.service.UsersService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://kacperkk2.github.io"})
public class UserController {

    private final UsersService usersService;

    @PostMapping()
    public ResponseEntity save(@RequestBody UserDto userDto) {
        try {
            return ResponseEntity.ok().body(usersService.save(userDto));
        }
        catch (UsersException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @DeleteMapping()
    public void deleteAll() {
        usersService.deleteAll();
    }

    @PostMapping("/setHost")
    public ResponseEntity setHost(@RequestParam String username) {
        try {
            return ResponseEntity.ok().body(usersService.setHost(username));
        }
        catch (UsersException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    @GetMapping()
    public ResponseEntity load() {
        return ResponseEntity.ok().body(usersService.load());
    }

    @PostMapping("{username}/notes")
    public ResponseEntity save(@PathVariable String username, @RequestBody NotesDto notesDto) {
        try {
            usersService.saveUserNotes(username, notesDto);
            return ResponseEntity.ok().body(null);
        }
        catch (UsersException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
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

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ErrorResponse {
        private String errorMessage;
    }
}
