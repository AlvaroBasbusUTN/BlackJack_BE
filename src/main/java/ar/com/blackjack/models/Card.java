package ar.com.blackjack.models;


import lombok.Data;

@Data
public class Card {

    private int number;
    private String suit;
    private boolean inGame=false;
    private int playerNumber;


}

