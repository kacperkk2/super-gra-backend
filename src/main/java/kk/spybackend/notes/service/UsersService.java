package kk.spybackend.notes.service;

import kk.spybackend.notes.model.NotesDto;
import kk.spybackend.notes.model.UserDto;

import java.util.List;

public interface UsersService {
    UserDto save(UserDto userDto);

    List<UserDto> load();

    void saveUserNotes(String username, NotesDto notesDto);

    UserDto setHost(String username);

    void deleteAll();

//    NoteDto load(String name);
//
//    String loadDefault();
//
//    List<NoteDto> loadAll();
//
//    void delete(String name);
}
