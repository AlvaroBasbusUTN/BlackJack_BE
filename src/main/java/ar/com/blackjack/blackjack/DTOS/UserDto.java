package ar.com.blackjack.blackjack.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long idUser;
    private String userName;
}
