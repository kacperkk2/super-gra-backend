package kk.spybackend.notes.service;

import kk.spybackend.notes.exceptions.GameOnGoingException;
import kk.spybackend.notes.model.Game;
import kk.spybackend.notes.model.GameInfo;
import kk.spybackend.notes.repo.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Override
    public Long startGame() {
        Game game = new Game();
        game.setStatus(true);
        return gameRepository.save(game).getId();
    }

    @Override
    public void endGame() {
        gameRepository.deleteAll();
    }

    @Override
    public GameInfo check() {
        Optional<Game> found = gameRepository.findById(1L);
        return new GameInfo(found.isPresent() ? "game ongoing" : "no game");
    }
}
