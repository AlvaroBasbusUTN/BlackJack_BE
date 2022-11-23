package ar.com.blackjack.blackjack.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "jugadacartas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JugadaCartas implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idJugada;

    @ManyToOne( targetEntity = Play.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idPlay")
    @JsonBackReference
    private Play play;

    private boolean jugador;

    @ManyToOne
    @JoinColumn(name = "id_carta",referencedColumnName = "id")
    private Card carta;

}
