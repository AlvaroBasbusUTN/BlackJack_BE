package ar.com.blackjack.blackjack.services;


import ar.com.blackjack.blackjack.models.Play;


import ar.com.blackjack.blackjack.repositories.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayServiceImpl implements PlayService<Play>{

    @Autowired
    PlayRepository playRepository;



    @Override
    public Play obtenerPartida(Long id) {
        Play play =playRepository.findById(id).orElse(null);

        return play;

    }

    @Override
    public List<Play> obtenerPartidas() {
        return playRepository.findAll();
    }

    @Override
    public void guardarPartida(Play play) {
        playRepository.save(play);
    }

    @Override
    public int obtenerUltimoId() {
        return playRepository.obtenerUltimoId()+1;
    }

    @Override
    public List<?> reporteJugFecha() {
        return playRepository.reporteJugFecha();
    }

    @Override
    public int reporteVictoriasCroupier() {
        return playRepository.reporteVictoriasCroupier();
    }

    @Override
    public int reporteVictoriasJugador() {
        return playRepository.reporteVictoriasJugador();
    }

    @Override
    public int reporteEmpates() {
        return playRepository.reporteEmpates();
    }




}
