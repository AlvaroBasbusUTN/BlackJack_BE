package ar.com.blackjack.blackjack.DTOS;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long id;
    private Integer number;
    private String palo;
    private boolean usada;
    private Integer valor;
    private String url;
}
