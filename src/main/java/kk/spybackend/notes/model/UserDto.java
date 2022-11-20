package kk.spybackend.notes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String username;
    private boolean isReady;
    private boolean isHost;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.isReady = user.getIsReady();
        this.isHost = user.getIsHost();
    }
}
