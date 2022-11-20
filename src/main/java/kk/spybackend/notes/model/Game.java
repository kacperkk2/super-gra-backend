package kk.spybackend.notes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Game {
    @Id
    private Long id = 1L;

    private boolean status;
}
