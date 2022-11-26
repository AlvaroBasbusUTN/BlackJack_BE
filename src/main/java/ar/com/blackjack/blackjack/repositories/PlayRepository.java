package ar.com.blackjack.blackjack.repositories;

import ar.com.blackjack.blackjack.models.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {

    @Query(
            value = "select max(id_play) from play",
            nativeQuery = true
    )
    public int obtenerUltimoId();

    @Query(
            value = "SELECT COUNT(DISTINCT id_play) as cantidadJuegos, " +
                    "COUNT(DISTINCT id_user) as cantidadJugadores, fecha as fecha " +
                    "FROM play " +
                    "GROUP BY fecha ",
            nativeQuery = true
    )
    public List<?> reporteJugFecha();

    @Query(
            value = "SELECT COUNT(DISTINCT id_play) as victorias " +
                    "FROM play " +
                    "WHERE ganador = 'croupier' ",
            nativeQuery = true
    )
    public int reporteVictoriasCroupier();

    @Query(
            value = "SELECT COUNT(DISTINCT id_play) as victorias " +
                    "FROM play " +
                    "WHERE ganador = 'jugador' ",
            nativeQuery = true
    )
    public int reporteVictoriasJugador();

    @Query(
            value = "SELECT COUNT(DISTINCT id_play) as empates " +
                    "FROM play " +
                    "WHERE ganador = 'empate' ",
            nativeQuery = true
    )
    public int reporteEmpates();








}
