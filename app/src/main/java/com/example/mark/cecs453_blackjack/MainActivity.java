package com.example.mark.cecs453_blackjack;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    AlertDialog levelDialog;
    final CharSequence[] items = {" 3 "," 5 "," 7"};
    AlertDialog.Builder builder;
    int numberOfRounds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start_game = (Button) findViewById(R.id.play_button);
        builder = new AlertDialog.Builder(this);
        start_game.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                builder.setTitle("Select Number of Rounds");
                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int option) {
                        switch(option)
                        {
                            case 0:
                                numberOfRounds = 3;
                                // Your code when first option seletced
                                playGame();
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                numberOfRounds = 5;
                                playGame();
                                break;
                            case 2:
                                numberOfRounds = 7;
                                playGame();
                                // Your code when 3rd option seletced
                                break;
                        }
                        levelDialog.dismiss();
                    }
                });
                levelDialog = builder.create();
                levelDialog.show();

            }
        });

    }
    public void playGame(){
        Intent i = new Intent(getApplicationContext(),playGame.class);
        i.putExtra("Number of Rounds", numberOfRounds);
        startActivity(i);
    }
}
