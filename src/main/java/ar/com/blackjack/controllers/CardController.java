package ar.com.blackjack.controllers;

import ar.com.blackjack.models.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

public class CardController {

    public CardController(){
        barajar();
    }

    private int[] numero = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private String[] suit = {"c", "d", "t", "p"};
    private Card card;
    public ArrayList listCards =new ArrayList<Card>();




    private void barajar(){
        for(int i=0; i< suit.length; i++){
            for (int j = 0; j < numero.length; j++) {
                card.setNumber(numero[j]);
                card.setSuit(suit[i]);
               listCards.add(card);
            }
        }
    }

    @GetMapping("/pedir/{num}")
    public String call(@PathVariable int num){

    return null;
    }









}
