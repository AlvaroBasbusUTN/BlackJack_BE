package ar.com.blackjack.blackjack.controllers;

import ar.com.blackjack.blackjack.DTOS.CardDto;
import ar.com.blackjack.blackjack.models.*;
import ar.com.blackjack.blackjack.services.CardService;
import ar.com.blackjack.blackjack.services.PlayService;
import ar.com.blackjack.blackjack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/play")
public class PlayController {

    @Autowired
    PlayService playService;
    @Autowired
    CardService cardService;
    @Autowired
    UserService userService;

    private Play play;
    private ArrayList<String> cardPlayer=new ArrayList<>();
    private ArrayList<String> cardCroupier=new ArrayList<>();
    private int cont;

    private List<CardDto> cartas;

   /* public PlayController( ){
        this.cartas=new ArrayList<CardDto>();
       // cartas= cardService.traer();
        cards=new Card[52];
        barajar();
        croupier=new Croupier();
        player=new Player();
        listaCroupier=new ArrayList<String>();
        listaPlayer=new ArrayList<String>();
        this.barajar();
    }

    */
    @PostConstruct
    public void load( ){
        this.cartas=new ArrayList<CardDto>();
        barajar();
        this.barajar();
    }


    @GetMapping("/all")
    public List<Play> getAllPlay(){
        return playService.obtenerPartidas();
    }

    private void barajar(){
        cartas= cardService.traer();

    }

    @GetMapping("/test")
    public List<CardDto> traerdto(){
        return cardService.traer();
    }


  //Iniciamos la partida, con 1 cartas para el croupier

    @GetMapping("/crearPartida/{id}")
    public Play crearPartida(@PathVariable Long id){
        this.barajar();
        play= new Play();
        LocalDate hoy = LocalDate.now();
        play.setFecha(hoy);

        var cartaJugador = pedirCarta();
        var jugadaUsuario=new JugadaCartas();
        jugadaUsuario.setJugador(true);
        jugadaUsuario.setCarta(cartaJugador);
        play.agregarCartas(jugadaUsuario);
        play.setPuntosJugador(calcularPuntos(cartaJugador, play.getPuntosJugador(), true));
        jugadaUsuario.setPlay(play);

        var carta2Jugador = pedirCarta();
        var jugada2Usuario=new JugadaCartas();
        jugada2Usuario.setJugador(true);
        jugada2Usuario.setCarta(carta2Jugador);
        play.agregarCartas(jugada2Usuario);
        play.setPuntosJugador(calcularPuntos(carta2Jugador, play.getPuntosJugador(), true));
        jugada2Usuario.setPlay(play);


        var cartaCroupier = pedirCarta();
        var jugadaCroupier = new JugadaCartas();
        jugadaCroupier.setJugador(false);
        jugadaCroupier.setCarta(cartaCroupier);
        play.agregarCartas(jugadaCroupier);
        play.setPuntosCroupier(calcularPuntos(cartaCroupier, play.getPuntosCroupier(), false));
        jugadaCroupier.setPlay(play);

        if(play.getPuntosJugador()==21){
            play.setFinalizada(true);
            play.setGanador("jugador");
        }else{
            play.setFinalizada(false);
        }
        play.setUser(userService.obtenerUsuario((long) id));

        playService.guardarPartida(play);

        return play;
    }


    @GetMapping("/pedirCartaJugador/{id}")
    public Play pedirCartaJugador(@PathVariable Long id){
         play= (Play) playService.obtenerPartida(id);

        var cartaJugador = pedirCarta();
        var jugadaUsuario=new JugadaCartas();
        jugadaUsuario.setJugador(true);
        jugadaUsuario.setCarta(cartaJugador);
        jugadaUsuario.setPlay(play);
        play.agregarCartas(jugadaUsuario);
        play.setPuntosJugador(calcularPuntos(cartaJugador, play.getPuntosJugador(), true));




        if(play.getPuntosJugador()>21){
            play.setFinalizada(true);
            play.setGanador("croupier");
        }
        playService.guardarPartida(play);
        return play;
    }




    @GetMapping("/pedirCartaCroupier/{id}")
    public Play pedirCartaCroupier(@PathVariable Long id){
        play= (Play) playService.obtenerPartida(id);

        while(play.getPuntosCroupier()<=16){
            var cartaCroupier = pedirCarta();
            var jugadaCroupier = new JugadaCartas();
            jugadaCroupier.setJugador(false);
            jugadaCroupier.setCarta(cartaCroupier);
            play.agregarCartas(jugadaCroupier);
            play.setPuntosCroupier(calcularPuntos(cartaCroupier, play.getPuntosCroupier(), false));
            jugadaCroupier.setPlay(play);

        }
        play.setFinalizada(true);
        resultados();
        playService.guardarPartida(play);
        return play;

    }

    private void resultados(){
        if(play.getPuntosCroupier() > play.getPuntosJugador() && play.getPuntosCroupier()<=21){
            play.setGanador("croupier");
        }
        if(play.getPuntosCroupier()>21){
            play.setGanador("jugador");
        }
        if(play.getPuntosCroupier() < play.getPuntosJugador() && play.getPuntosJugador()<=21){
            play.setGanador("jugador");
        }
        if(play.getPuntosJugador() == play.getPuntosCroupier()){
            play.setGanador("empate");
        }
    }

    private Integer calcularPuntos(Card carta, Integer puntos, boolean esJugador) {
        if(esJugador){
            if(carta.getValor() == 1 && puntos==10 ){
                puntos+=11;
            }else{
                puntos+=carta.getValor();
            }
        }

      //  if(carta.getValor() == 1 && puntos<10){
        //    puntos+=1;
        //}
        //if(carta.getValor() == 1 && puntos>10){
          //  puntos+=1;
       // }
      // if(carta.getValor() == 1 && puntos==10 ){
      //      puntos+=11;
      //  }
        //if(carta.getValor()!=1){
         //   puntos+=carta.getValor();
        //}
        if(!esJugador){
            puntos+=carta.getValor();
            if(carta.getValor()==1 && puntos<10){
                int suma= carta.getValor()+10;
                if(suma>play.getPuntosJugador()){
                    puntos+=10;
                }

            }


         //   if(puntos>=21){
          //      pedirCartaCroupier();
         //   }
        }

        return puntos;
    }


    private Card pedirCarta(){
        Card carta=new Card();
        int x= new Random().nextInt(52);
        while(cartas.get(x).isUsada()){
            x= new Random().nextInt(52);
        }

            Long i= cartas.get(x).getId();
            carta= cardService.findById(cartas.get(x).getId());
            cartas.get(x).setUsada(true);

        return carta;
    }





}
