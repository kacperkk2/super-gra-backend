package kk.spybackend.notes.repo;

import kk.spybackend.notes.model.Game;
import kk.spybackend.notes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {
}
