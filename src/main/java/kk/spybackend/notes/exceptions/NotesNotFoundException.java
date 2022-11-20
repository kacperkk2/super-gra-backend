package kk.spybackend.notes.exceptions;

public class NotesNotFoundException extends RuntimeException {

    public NotesNotFoundException(String name) {
        super("Node with name " + name + " not found");
    }
}
