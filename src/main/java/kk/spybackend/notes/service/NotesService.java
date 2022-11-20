package kk.spybackend.notes.service;

import kk.spybackend.notes.model.NoteDto;
import kk.spybackend.notes.model.NotesDto;

import java.util.List;

public interface NotesService {
    List<NoteDto> get();
//    NoteDto save(NoteDto noteDto);
//
//    NoteDto load(String name);
//
//    String loadDefault();
//
//    List<NoteDto> loadAll();
//
//    void delete(String name);
}
