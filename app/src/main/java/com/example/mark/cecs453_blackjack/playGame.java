package com.example.mark.cecs453_blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;


import java.util.ArrayList;
import java.util.Random;

public class playGame extends AppCompatActivity {
    ImageView pos_1;
    ImageView pos_2;
    ImageView pos_3;
    ImageView pos_4;
    ImageView pos_5;
    ImageView pos_6;
    ImageView pos_7;
    ImageView pos_8;
    ImageView pos_9;
    ImageView pos_10;
    ImageView pos_11;
    ImageView pos_12;
    ImageView pos_13;
    ImageView pos_14;
    ImageView pos_15;
    ImageView pos_16;

    ArrayList<Card> playingDeck = new ArrayList<Card>();
    ArrayList<Card> opponentsHand = new ArrayList<Card>();
    ArrayList<Card> playerHand = new ArrayList<Card>();
    int playerValue;
    int numberOfCards = 51;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Button hit = (Button) findViewById(R.id.hit_button);
        Button stay = (Button) findViewById(R.id.hit_button);
        makeDeck();
        makeViews();
        deal();
    }

    private void makeViews() {
        pos_1  = (ImageView) findViewById(R.id.imageView4);
        pos_2  = (ImageView) findViewById(R.id.imageView4);
        pos_3  = (ImageView) findViewById(R.id.imageView4);
        pos_4  = (ImageView) findViewById(R.id.imageView4);
        pos_5  = (ImageView) findViewById(R.id.imageView4);
        pos_6  = (ImageView) findViewById(R.id.imageView4);
        pos_7  = (ImageView) findViewById(R.id.imageView4);
        pos_8  = (ImageView) findViewById(R.id.imageView4);
        pos_9  = (ImageView) findViewById(R.id.imageView4);
        pos_10 = (ImageView) findViewById(R.id.imageView4);
        pos_11 = (ImageView) findViewById(R.id.imageView4);
        pos_12 = (ImageView) findViewById(R.id.imageView4);
        pos_13 = (ImageView) findViewById(R.id.imageView4);
        pos_14 = (ImageView) findViewById(R.id.imageView4);
        pos_15 = (ImageView) findViewById(R.id.imageView4);
        pos_16 = (ImageView) findViewById(R.id.imageView4);
    }
    public void setCardImage(Card card, int pos){ //Basically put card in imageview pos.
        switch(pos){

        };

    }

    public void makeDeck() {
        playingDeck.add(new Card("ace", 11, "spades", "ace_of_spades.png"));
        playingDeck.add(new Card("ace", 11, "clubs", "ace_of_clubs.png"));
        playingDeck.add(new Card("ace", 11, "diamonds", "ace_of_diamonds.png"));
        playingDeck.add(new Card("ace", 11, "hearts", "ace_of_hearts.png"));

        playingDeck.add(new Card("two", 2, "spades", "2_of_spades.png"));
        playingDeck.add(new Card("two", 2, "clubs", "2_of_clubs.png"));
        playingDeck.add(new Card("two", 2, "diamonds", "2_of_diamonds.png"));
        playingDeck.add(new Card("two", 2, "hearts", "2_of_hearts.png"));

        playingDeck.add(new Card("three", 3, "spades", "3_of_spades.png"));
        playingDeck.add(new Card("three", 3, "clubs", "3_of_clubs.png"));
        playingDeck.add(new Card("three", 3, "diamonds", "3_of_diamonds.png"));
        playingDeck.add(new Card("three", 3, "hearts", "3_of_hearts.png"));

        playingDeck.add(new Card("four", 4, "spades", "4_of_spades.png"));
        playingDeck.add(new Card("four", 4, "clubs", "4_of_clubs.png"));
        playingDeck.add(new Card("four", 4, "diamonds", "4_of_diamonds.png"));
        playingDeck.add(new Card("four", 4, "hearts", "4_of_hearts.png"));

        playingDeck.add(new Card("five", 5, "spades", "5_of_spades.png"));
        playingDeck.add(new Card("five", 5, "clubs", "5_of_clubs.png"));
        playingDeck.add(new Card("five", 5, "diamonds", "5_of_diamonds.png"));
        playingDeck.add(new Card("five", 5, "hearts", "5_of_hearts.png"));

        playingDeck.add(new Card("six", 6, "spades", "6_of_spades.png"));
        playingDeck.add(new Card("six", 6, "clubs", "6_of_clubs.png"));
        playingDeck.add(new Card("six", 6, "diamonds", "6_of_diamonds.png"));
        playingDeck.add(new Card("six", 6, "hearts", "6_of_hearts.png"));

        playingDeck.add(new Card("seven", 7, "spades", "7_of_spades.png"));
        playingDeck.add(new Card("seven", 7, "clubs", "7_of_spades.png"));
        playingDeck.add(new Card("seven", 7, "diamonds", "7_of_spades.png"));
        playingDeck.add(new Card("seven", 7, "hearts", "7_of_spades.png"));

        playingDeck.add(new Card("eight", 8, "spades", "8_of_spades.png"));
        playingDeck.add(new Card("eight", 8, "clubs", "8_of_clubs.png"));
        playingDeck.add(new Card("eight", 8, "diamonds", "8_of_diamonds.png"));
        playingDeck.add(new Card("eight", 8, "hearts", "8_of_hearts.png"));

        playingDeck.add(new Card("nine", 9, "spades", "9_of_spades.png"));
        playingDeck.add(new Card("nine", 9, "clubs", "9_of_clubs.png"));
        playingDeck.add(new Card("nine", 9, "diamonds", "9_of_diamonds.png"));
        playingDeck.add(new Card("nine", 9, "hearts", "9_of_hearts.png"));

        playingDeck.add(new Card("jack", 10, "spades", "jack_of_spades.png"));
        playingDeck.add(new Card("jack", 10, "clubs", "jack_of_clubs.png"));
        playingDeck.add(new Card("jack", 10, "diamonds", "jack_of_diamonds.png"));
        playingDeck.add(new Card("jack", 10, "hearts", "jack_of_hearts.png"));

        playingDeck.add(new Card("queen", 10, "spades", "queen_of_spades.png"));
        playingDeck.add(new Card("queen", 10, "clubs", "queen_of_clubs.png"));
        playingDeck.add(new Card("queen", 10, "diamonds", "queen_of_diamonds.png"));
        playingDeck.add(new Card("queen", 10, "hearts", "queen_of_hearts.png"));

        playingDeck.add(new Card("king", 10, "spades", "king_of_spades.png"));
        playingDeck.add(new Card("king", 10, "clubs", "king_of_clubs.png"));
        playingDeck.add(new Card("king", 10, "diamonds", "king_of_diamonds.png"));
        playingDeck.add(new Card("king", 10, "hearts", "ace_of_hearts.png"));
    }

    public void deal() {
        Random randomNumber = new Random();
        int randomCard;
        for (int i = 1; i < 2; i++) {
            randomCard = randomNumber.nextInt(numberOfCards);
            playerHand.add(playingDeck.get(randomCard));
            playingDeck.remove(playingDeck.get(randomCard));
            numberOfCards--;
        }
        for (int i = 1; i < 2; i++) {
            randomCard = randomNumber.nextInt(numberOfCards);
            opponentsHand.add(playingDeck.get(randomCard));
            playingDeck.remove(playingDeck.get(randomCard));
            numberOfCards--;
        }
    }

}
