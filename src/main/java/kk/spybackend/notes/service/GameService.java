package kk.spybackend.notes.service;

import kk.spybackend.notes.model.GameInfo;

public interface GameService {
    Long startGame();
    void endGame();

    GameInfo check();
}
