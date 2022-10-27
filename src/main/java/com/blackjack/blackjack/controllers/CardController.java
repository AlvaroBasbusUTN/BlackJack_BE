package com.blackjack.blackjack.controllers;


import com.blackjack.blackjack.models.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
public class CardController {



    private int[] numero = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private String[] suit=  {"c", "d", "t", "p"};
    private Card card;

    private Card[] cards;

    ArrayList<Card> list = new ArrayList<>();


    public CardController(){
        card=new Card();
        cards=new Card[52];

       barajar();
    }




    private void barajar(){
           int w=0;

            for (int j = 0; j < numero.length; j++){
                for(int i=0; i< suit.length; i++) {

                    //card.setSuit(suit[i]);
                    //card.setNumber(numero[j]);
                   // cards[1].setSuit(suit[i]);
                    cards[w] = new Card(numero[j], suit[i]);
                    //cards[1].setNumber(numero[j]);
                    w+=1;

                    list.add(card);
            }


        }



    }

    @GetMapping("/pedir/{num}")
    public String call(@PathVariable int num){

    return null;
    }

     @GetMapping("/pedir/")
    public String call(){
       int x= new Random().nextInt(52);
       //list.get(x).isInGame();
      //   if(list.get(numero).isInGame()==true){
        // call();
          //  }
        // list.get(x).setInGame(true);
       String carta= x + " - " + cards[x].getNumber()  + cards[x].getSuit();

    return carta;
    }








}
