package kk.spybackend.notes.service;

import kk.spybackend.notes.exceptions.UsersException;
import kk.spybackend.notes.model.Note;
import kk.spybackend.notes.model.NotesDto;
import kk.spybackend.notes.model.User;
import kk.spybackend.notes.model.UserDto;
import kk.spybackend.notes.repo.NotesRepository;
import kk.spybackend.notes.repo.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final NotesRepository notesRepository;

    @Override
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setIsReady(userDto.isReady());
        user.setIsHost(userDto.isHost());
        User saved;
        try {
            saved = usersRepository.save(user);
        } catch (Exception e) {
            throw new UsersException("Username already picked");
        }
        return new UserDto(saved);
    }

    @Override
    public UserDto setHost(String username) {
        if (!usersRepository.findByIsHostTrue().isEmpty()) {
            throw new UsersException("Host already picked");
        }
        User user = usersRepository.findByUsername(username).orElseThrow(() -> new UsersException("User nor found"));
        user.setIsHost(true);
        return new UserDto(usersRepository.save(user));
    }

    @Override
    public void deleteAll() {
        usersRepository.deleteAll();
    }

    @Override
    public List<UserDto> load() {
        return usersRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    @Override
    public void saveUserNotes(String username, NotesDto notesDto) {
        User user = usersRepository.findByUsername(username).orElseThrow(() -> new UsersException("User nor found"));
        Note place = new Note();
        place.setUser(user);
        place.setContent(notesDto.getPlace());
        Note event = new Note();
        event.setUser(user);
        event.setContent(notesDto.getEvent());
        Note thing = new Note();
        thing.setUser(user);
        thing.setContent(notesDto.getThing());
        List<Note> notes = new ArrayList<>(List.of(place, event, thing));
        user.setNotes(notes);
        user.setIsReady(true);
        usersRepository.save(user);
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
