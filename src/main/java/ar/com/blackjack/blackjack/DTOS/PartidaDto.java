package ar.com.blackjack.blackjack.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaDto {

    private Long idPlay;

    private LocalDate fecha;

    private Integer puntosJugador=0;

    private Integer puntosCroupier=0;

    private Boolean finalizada;

    private String ganador;
}
