package com.blackjack.blackjack.models;


import lombok.Data;

@Data
public class Card {


    private int number;
    private String suit;
    private boolean inGame=false;
    private int playerNumber;

    public Card(int number, String suit){
        this.number=number;
        this.suit=suit;

    }

    public Card(){

    }

}

