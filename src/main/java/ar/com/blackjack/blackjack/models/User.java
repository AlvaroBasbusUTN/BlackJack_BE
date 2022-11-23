package ar.com.blackjack.blackjack.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @OneToMany(targetEntity = Play.class, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Play> plays= new ArrayList<Play>();


    public void agregarPartida(Play play){
        this.plays.add(play);
    }



}
