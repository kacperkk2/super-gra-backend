package kk.spybackend.notes.controller;

import kk.spybackend.notes.model.GameInfo;
import kk.spybackend.notes.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "https://kacperkk2.github.io"})
public class GameController {

    private final GameService gameService;

    @PostMapping()
    public ResponseEntity start() {
        return ResponseEntity.ok().body(gameService.startGame());
    }

    @DeleteMapping()
    public void end() {
        gameService.endGame();
    }

    @GetMapping()
    public ResponseEntity<GameInfo> check() {
        return ResponseEntity.ok().body(gameService.check());
    }
}
