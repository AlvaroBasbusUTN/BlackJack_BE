package ar.com.blackjack.blackjack.services;

import ar.com.blackjack.blackjack.models.Play;

import java.util.List;

public interface PlayService<E> {

    public E obtenerPartida(Long id);

    public List<E> obtenerPartidas();

    public void guardarPartida(E entity);

    public int obtenerUltimoId();

    // reportes

    public List<?> reporteJugFecha();

    public List<?> reporteVictoriasCroupier();

    public List<?> reporteVictoriasJugador();

    public List<?> reporteEmpates();

    public List<?> reportePromedios();

}
