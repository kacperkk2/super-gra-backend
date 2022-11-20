package kk.spybackend.notes.exceptions;

public class GameOnGoingException extends RuntimeException {

    public GameOnGoingException() {
        super("Game ongoing");
    }
}
