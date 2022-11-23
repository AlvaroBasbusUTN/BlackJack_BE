package ar.com.blackjack.blackjack.controllers;


import ar.com.blackjack.blackjack.services.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private ResponseEntity<?> VictoriasCroupier(){
        var list= playService.reporteVictoriasCroupier();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/victoriaJugador")
    @ResponseBody
    private ResponseEntity<?> victoriasJugador(){
        var list= playService.reporteVictoriasJugador();
        return ResponseEntity.ok(list);
    }


    @GetMapping("/empates")
    @ResponseBody
    private ResponseEntity<?> reporteEmpates(){
        var list= playService.reporteEmpates();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/promedio")
    @ResponseBody
    private ResponseEntity<?> reportePromedios(){
        var list= playService.reportePromedios();
        return ResponseEntity.ok(list);
    }

}
