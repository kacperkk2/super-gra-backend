package kk.spybackend.notes.repo;

import kk.spybackend.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotesRepository extends JpaRepository<Note, Long> {
//    Optional<Note> findByName(String name);
//    void deleteByName(String name);
}
