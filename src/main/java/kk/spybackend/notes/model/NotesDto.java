package kk.spybackend.notes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotesDto {
    private String place;
    private String event;
    private String thing;
}
