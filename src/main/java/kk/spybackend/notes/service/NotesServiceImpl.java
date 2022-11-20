package kk.spybackend.notes.service;

import kk.spybackend.notes.model.Note;
import kk.spybackend.notes.model.NoteDto;
import kk.spybackend.notes.model.NotesDto;
import kk.spybackend.notes.repo.NotesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NotesService {
    private final NotesRepository notesRepository;

    @Override
    public List<NoteDto> get() {
        List<Note> all = notesRepository.findAll();
        return all.stream().map(note -> new NoteDto(note.getContent())).collect(Collectors.toList());
    }

//    @Override
//    public NoteDto save(NoteDto noteDto) {
//        Note note = new Note();
//        note.setLocations(noteDto.getLocations());
//        note.setName(noteDto.getName());
//        Note saved = notesRepository.save(note);
//        NoteDto returnDto = new NoteDto();
//        returnDto.setName(saved.getName());
//        return returnDto;
//    }
//
//    @Override
//    public NoteDto load(String name) {
//        Note found = notesRepository.findByName(name).orElseThrow(() -> new NotesNotFoundException(name));
//        NoteDto returnDto = new NoteDto();
//        returnDto.setName(found.getName());
//        returnDto.setLocations(found.getLocations());
//        return returnDto;
//    }
//
//    @Override
//    public String loadDefault() {
//        Long id = defaultLocationsManager.getDefaultId();
//        Note found = notesRepository.findById(id).orElseThrow(() -> new NotesNotFoundException(id.toString()));
//        return found.getLocations();
//    }
//
//    @Override
//    public List<NoteDto> loadAll() {
//        List<Note> notes = notesRepository.findAll();
//        return notes.stream().map(note -> {
//            NoteDto returnDto = new NoteDto();
//            returnDto.setName(note.getName());
//            returnDto.setLocations(note.getLocations());
//            return returnDto;
//        }).collect(Collectors.toList());
//    }
//
//    @Override
//    @Transactional
//    public void delete(String name) {
//        notesRepository.deleteByName(name);
//    }
}
