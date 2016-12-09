package com.example.mark.cecs453_blackjack;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
    AlertDialog levelDialog;
    final CharSequence[] items = {" Next Round ", "Reshuffle"};
    AlertDialog.Builder builder;
    HashMap<Integer, ImageView> positions = new HashMap();
    ArrayList<Card> playingDeck = new ArrayList<Card>();
    ArrayList<Card> opponentsHand = new ArrayList<Card>();
    ArrayList<Card> playerHand = new ArrayList<Card>();
    int playerValue;
    int opponentValue;
    int numberOfCards;
    Button hit;
    Button stay;
    int numberOfRounds;
    int currentRound = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        playerValue = 0;
        opponentValue = 0;
        hit = (Button) findViewById(R.id.hit_button);
        stay = (Button) findViewById(R.id.hit_button);
        Intent myIntent = getIntent();
        Bundle myBundle = myIntent.getExtras();
        numberOfRounds = myBundle.getInt("Number of Rounds");

        makeDeck();
        makeViews();
        InputStream inputStream = null;
        deal();
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create class object
                if(playerHand.size() < 8) {
                    Random randomNumber = new Random();
                    int randomCard = randomNumber.nextInt(numberOfCards);
                    playerHand.add(playingDeck.get(randomCard));
                    playerValue += playingDeck.get(randomCard).getValue();
                    playingDeck.remove(playingDeck.get(randomCard));
                    setCardImage(playerHand.get(playerHand.size()-1), playerHand.size()-1);
                    if (playerValue > 21) {
                        for (int i = 0; i < playerHand.size(); i++) {
                            if (playerHand.get(i).getName().equals("ace") && playerHand.get(i).getValue() == 11) {
                                playerValue -= 10;
                                playerHand.get(i).setValue(1);
                                break;
                            }
                        }
                    }
                }
                else{
                    hit.setVisibility(Button.INVISIBLE);
                }
            }
        });
        stay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // create class object
                hit.setVisibility(Button.INVISIBLE);
                stay.setVisibility(Button.INVISIBLE);
                opponentsTurn();
            }
        });
    }
    private void makeViews() {
        pos_1  = (ImageView) findViewById(R.id.imageView0);
        pos_2  = (ImageView) findViewById(R.id.imageView1);
        pos_3  = (ImageView) findViewById(R.id.imageView2);
        pos_4  = (ImageView) findViewById(R.id.imageView3);
        pos_5  = (ImageView) findViewById(R.id.imageView4);
        pos_6  = (ImageView) findViewById(R.id.imageView5);
        pos_7  = (ImageView) findViewById(R.id.imageView6);
        pos_8  = (ImageView) findViewById(R.id.imageView7);
        //positions from this pt are opponents hand
        pos_9  = (ImageView) findViewById(R.id.imageView8);
        pos_10 = (ImageView) findViewById(R.id.imageView9);
        pos_11 = (ImageView) findViewById(R.id.imageView10);
        pos_12 = (ImageView) findViewById(R.id.imageView11);
        pos_13 = (ImageView) findViewById(R.id.imageView12);
        pos_14 = (ImageView) findViewById(R.id.imageView13);
        pos_15 = (ImageView) findViewById(R.id.imageView14);
        pos_16 = (ImageView) findViewById(R.id.imageView15);
        positions.put(0,pos_1);
        positions.put(1,pos_2);
        positions.put(2,pos_3);
        positions.put(3,pos_4);
        positions.put(4,pos_5);
        positions.put(5,pos_6);
        positions.put(6,pos_7);
        positions.put(7,pos_8);
        positions.put(8,pos_9);
        positions.put(9,pos_10);
        positions.put(10,pos_11);
        positions.put(11,pos_12);
        positions.put(12,pos_13);
        positions.put(13,pos_14);
        positions.put(14,pos_15);
        positions.put(15,pos_16);

    }
    public void setCardImage(Card card,int pos) { //Basically put card in imageview pos.
        int resID = getResources().getIdentifier(card.getImage(), "drawable",  getPackageName());
        positions.get(pos).setImageResource(resID);
    }
    public void makeDeck() {
         //new Card ("ace", 11, "spades", R.drawable.ace_of_spades); kelvin this is the new format now
        playingDeck.add(new Card("ace", 11, "spades", "ace_of_spades"));
        playingDeck.add(new Card("ace", 11, "clubs", "ace_of_clubs"));
        playingDeck.add(new Card("ace", 11, "diamonds", "ace_of_diamonds"));
        playingDeck.add(new Card("ace", 11, "hearts", "ace_of_hearts"));

        playingDeck.add(new Card("two", 2, "spades", "2_of_spades"));
        playingDeck.add(new Card("two", 2, "clubs", "2_of_clubs"));
        playingDeck.add(new Card("two", 2, "diamonds", "2_of_diamonds"));
        playingDeck.add(new Card("two", 2, "hearts", "2_of_hearts"));

        playingDeck.add(new Card("three", 3, "spades", "3_of_spades"));
        playingDeck.add(new Card("three", 3, "clubs", "3_of_clubs"));
        playingDeck.add(new Card("three", 3, "diamonds", "3_of_diamonds"));
        playingDeck.add(new Card("three", 3, "hearts", "3_of_hearts"));

        playingDeck.add(new Card("four", 4, "spades", "4_of_spades"));
        playingDeck.add(new Card("four", 4, "clubs", "4_of_clubs"));
        playingDeck.add(new Card("four", 4, "diamonds", "4_of_diamonds"));
        playingDeck.add(new Card("four", 4, "hearts", "4_of_hearts"));

        playingDeck.add(new Card("five", 5, "spades", "5_of_spades"));
        playingDeck.add(new Card("five", 5, "clubs", "5_of_clubs"));
        playingDeck.add(new Card("five", 5, "diamonds", "5_of_diamonds"));
        playingDeck.add(new Card("five", 5, "hearts", "5_of_hearts"));

        playingDeck.add(new Card("six", 6, "spades", "6_of_spades"));
        playingDeck.add(new Card("six", 6, "clubs", "6_of_clubs"));
        playingDeck.add(new Card("six", 6, "diamonds", "6_of_diamonds"));
        playingDeck.add(new Card("six", 6, "hearts", "6_of_hearts"));

        playingDeck.add(new Card("seven", 7, "spades", "7_of_spades"));
        playingDeck.add(new Card("seven", 7, "clubs", "7_of_spades"));
        playingDeck.add(new Card("seven", 7, "diamonds", "7_of_spades"));
        playingDeck.add(new Card("seven", 7, "hearts", "7_of_spades"));

        playingDeck.add(new Card("eight", 8, "spades", "8_of_spades"));
        playingDeck.add(new Card("eight", 8, "clubs", "8_of_clubs"));
        playingDeck.add(new Card("eight", 8, "diamonds", "8_of_diamonds"));
        playingDeck.add(new Card("eight", 8, "hearts", "8_of_hearts"));

        playingDeck.add(new Card("nine", 9, "spades", "9_of_spades"));
        playingDeck.add(new Card("nine", 9, "clubs", "9_of_clubs"));
        playingDeck.add(new Card("nine", 9, "diamonds", "9_of_diamonds"));
        playingDeck.add(new Card("nine", 9, "hearts", "9_of_hearts"));

        playingDeck.add(new Card("jack", 10, "spades", "jack_of_spades"));
        playingDeck.add(new Card("jack", 10, "clubs", "jack_of_clubs"));
        playingDeck.add(new Card("jack", 10, "diamonds", "jack_of_diamonds"));
        playingDeck.add(new Card("jack", 10, "hearts", "jack_of_hearts"));

        playingDeck.add(new Card("queen", 10, "spades", "queen_of_spades"));
        playingDeck.add(new Card("queen", 10, "clubs", "queen_of_clubs"));
        playingDeck.add(new Card("queen", 10, "diamonds", "queen_of_diamonds"));
        playingDeck.add(new Card("queen", 10, "hearts", "queen_of_hearts"));

        playingDeck.add(new Card("king", 10, "spades", "king_of_spades"));
        playingDeck.add(new Card("king", 10, "clubs", "king_of_clubs"));
        playingDeck.add(new Card("king", 10, "diamonds", "king_of_diamonds"));
        playingDeck.add(new Card("king", 10, "hearts", "ace_of_hearts"));
        numberOfCards = playingDeck.size();
    }

    public void deal() {
        Random randomNumber = new Random();
        int randomCard;
        for (int i = 0; i < 2; i++) {
            randomCard = randomNumber.nextInt(numberOfCards);
            playerHand.add(playingDeck.get(randomCard));
            playingDeck.remove(playingDeck.get(randomCard));
            numberOfCards--;
            playerValue += playerHand.get(i).getValue();
            setCardImage(playerHand.get(i),i);
        }
        for (int i = 0; i < 2; i++) {
            randomCard = randomNumber.nextInt(numberOfCards);
            opponentsHand.add(playingDeck.get(randomCard));
            playingDeck.remove(playingDeck.get(randomCard));
            numberOfCards--;
            playerValue += opponentsHand.get(i).getValue();
        }
        setCardImage(opponentsHand.get(0),8);

    }
    public void reshuffle(){
        playingDeck.clear();
        makeDeck();
    }
    public void opponentsTurn(){
        Random randomNumber = new Random();
        int randomCard;

        randomCard = randomNumber.nextInt(numberOfCards);
        boolean breakLoop = false;
        for(int i = 0; i< opponentsHand.size(); i++){
            if(opponentValue < 15){
                opponentsHand.add(playingDeck.get(randomCard));
                opponentValue += playingDeck.get(randomCard).getValue();
                playingDeck.remove(playingDeck.get(randomCard));
                numberOfCards--;
            }
            while(opponentValue > 21 || !breakLoop){
                for(int j = 0; j < opponentsHand.size(); j++){
                    if(opponentsHand.get(j).getName().equals("ace") && opponentsHand.get(j).getValue() == 11){
                        opponentsHand.get(j).setValue(1);
                        opponentValue -= 10;
                        break;
                    }
                    else{
                        breakLoop = true;
                    }
                }

            }
        }
        compareHands();
    }
    public void compareHands() {
        for (int i = 0; i < opponentsHand.size(); i++) {
            setCardImage(opponentsHand.get(i), i + 8);
        }

        if (playerValue > opponentValue) {
            hit.setVisibility(Button.VISIBLE);
            stay.setVisibility(Button.VISIBLE);
        } else if (playerValue < opponentValue) {
            //loss
            hit.setVisibility(Button.VISIBLE);
            stay.setVisibility(Button.VISIBLE);
        }
        currentRound++;
        if (currentRound < 3) {
            builder = new AlertDialog.Builder(this);
            builder.setTitle("Round over");

            builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int option) {
                    switch (option) {
                        case 0:
                            playerHand.clear();
                            opponentsHand.clear();
                            playerValue = 0;
                            opponentValue = 0;
                            // Your code when first option seletced
                            break;
                        case 1:
                            reshuffle();
                            break;

                    }
                    levelDialog.dismiss();
                }
            });
            levelDialog = builder.create();
            levelDialog.show();

        }
        else{
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        }
    }
}

