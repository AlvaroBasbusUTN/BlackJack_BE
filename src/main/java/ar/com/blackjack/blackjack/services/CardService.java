package ar.com.blackjack.blackjack.services;

import ar.com.blackjack.blackjack.DTOS.CardDto;
import ar.com.blackjack.blackjack.models.Card;


import java.util.List;


public interface CardService {

    public List<Card> findAll();

    public List<CardDto> traer();

    public Card findById(Long id);
}
