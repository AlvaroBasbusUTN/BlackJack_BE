package ar.com.blackjack.blackjack.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cartas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private String palo;
    private Integer valor;

    @Column(name = "url")
    private String url;

}
