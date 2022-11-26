package ar.com.blackjack.blackjack.controllers;


import ar.com.blackjack.blackjack.services.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reporte")
public class ReporteController {

    @Autowired
    PlayService playService;


    @GetMapping("/jugFechas")
    @ResponseBody
    public ResponseEntity<?> reporteJugFecha(){
        var list= playService.reporteJugFecha();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/victoriasCroupier")
    @ResponseBody
    private int VictoriasCroupier(){
        return playService.reporteVictoriasCroupier();
    }

    @GetMapping("/victoriaJugador")
    @ResponseBody
    private int victoriasJugador(){
        return playService.reporteVictoriasJugador();
    }


    @GetMapping("/empates")
    @ResponseBody
    private int empates(){
        return playService.reporteEmpates();
    }





}
