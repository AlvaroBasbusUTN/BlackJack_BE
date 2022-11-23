package ar.com.blackjack.blackjack.repositories;

import ar.com.blackjack.blackjack.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
