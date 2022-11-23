package ar.com.blackjack.blackjack.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "play")
public class Play  implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idPlay;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "puntosJugador")
    private Integer puntosJugador=0;
    @Column(name = "puntosCroupier")
    private Integer puntosCroupier=0;
    @Column(name = "finalizada")
    private Boolean finalizada;
    @Column(name = "ganador")
    private String ganador;

    @OneToMany(targetEntity = JugadaCartas.class, mappedBy = "play", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<JugadaCartas> jugadaCartas= new ArrayList<JugadaCartas>();



    @ManyToOne( targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonBackReference
    private User user;


    public void agregarCartas(JugadaCartas jugada){
        this.jugadaCartas.add(jugada);
    }


}
