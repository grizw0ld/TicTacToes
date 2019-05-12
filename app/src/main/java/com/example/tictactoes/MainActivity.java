package com.example.tictactoes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean gameover = false;
    String winner = "";

    ImageView topLeft;
    ImageView topMiddle;
    ImageView topRight ;
    ImageView middleLeft;
    ImageView middleMiddle;
    ImageView middleRight;
    ImageView bottomLeft;
    ImageView bottomMiddle;
    ImageView bottomRight;
    TextView winnerMessage;
    Button playAgain;

    int topRed;
    int topYellow;
    int middleRed;
    int middleYellow;
    int bottomRed;
    int bottomYellow;
    int leftRed;
    int leftYellow;
    int vertMiddleRed;
    int vertMiddleYellow;
    int rightRed;
    int rightYellow;
    int diagLeftToRightRed;
    int diagLeftToRightYellow;
    int diagRightToLeftRed;
    int diagRightToLeftYellow;

    int turn = 0;

    public void restart(){
        gameover = false;
        winner = "";
        turn = 0;

        topRed=0;
        topYellow=0;
        middleRed=0;
        middleYellow=0;
        bottomRed=0;
        bottomYellow=0;
        leftRed=0;
        leftYellow=0;
        vertMiddleRed=0;
        vertMiddleYellow=0;
        rightRed=0;
        rightYellow=0;
        diagLeftToRightRed=0;
        diagLeftToRightYellow=0;
        diagRightToLeftRed=0;
        diagRightToLeftYellow=0;

    }

    public void checkGame(){

        if(topRed ==3 || bottomRed == 3 || middleRed ==3 || leftRed ==3 || vertMiddleRed ==3 || rightRed ==3 || diagLeftToRightRed == 3 || diagRightToLeftRed ==3){
            gameover = true;
            winner = "Red";
        }else if(topYellow==3||bottomYellow==3||middleYellow==3||leftYellow==3||vertMiddleYellow==3||rightYellow==3||diagRightToLeftYellow==3||diagLeftToRightYellow==3){
            gameover = true;
            winner = "Yellow";
        }

        if(gameover){
            winnerMessage = findViewById(R.id.winnerMessage);
            winnerMessage.setText(winner + " Wins!");
            winnerMessage.animate().alpha(1);
            playAgain = findViewById(R.id.playAgainButton);
            playAgain.setEnabled(true);
            playAgain.animate().alpha(1);
        }
    }



    public void selectedSpace(ImageView x){
            if (turn % 2 == 0) {
                x.setImageResource(R.drawable.red);
            } else {
                x.setImageResource(R.drawable.yellow);
            }

            x.setY(-1000);
            x.animate().alpha(1);
            x.animate().translationY(0).setDuration(1000);

            x.setEnabled(false);
            turn +=1;

            if(x == topLeft){
                if (turn%2!=0){
                    topRed +=1;
                    leftRed +=1;
                    diagLeftToRightRed +=1;
                }else{
                    topYellow +=1;
                    leftYellow +=1;
                    diagLeftToRightYellow +=1;
                }
            }else if(x == topMiddle){
                if (turn%2!=0){
                    vertMiddleRed +=1;
                    topRed +=1;
                }else{
                    vertMiddleYellow +=1;
                     topYellow +=1;
                }
            }else if(x == topRight){
                if (turn%2!=0){
                    topRed +=1;
                    rightRed +=1;
                    diagRightToLeftRed +=1;
                }else{
                    topYellow +=1;
                    rightYellow +=1;
                    diagRightToLeftYellow +=1;
                }
            }else if(x == middleLeft){
                if (turn%2!=0){
                    middleRed +=1;
                    leftRed +=1;
                }else{
                    middleYellow +=1;
                    leftYellow +=1;
                }
            }else if(x == middleMiddle){
                if (turn%2!=0){
                    middleRed +=1;
                    vertMiddleRed +=1;
                    diagLeftToRightRed +=1;
                    diagRightToLeftRed +=1;
                }else{
                    middleYellow +=1;
                    vertMiddleYellow +=1;
                    diagLeftToRightYellow +=1;
                    diagRightToLeftYellow +=1;
                }
            }else if(x == middleRight){
                if (turn%2!=0){
                    middleRed +=1;
                    rightRed +=1;
                }else{
                    middleYellow +=1;
                    rightYellow +=1;
                }
            }else if(x == bottomLeft){
                if (turn%2!=0){
                    bottomRed +=1;
                    leftRed +=1;
                    diagRightToLeftRed +=1;
                }else{
                    bottomYellow +=1;
                    leftYellow +=1;
                    diagRightToLeftYellow +=1;
                }
            }else if(x == bottomMiddle){
                if (turn%2!=0){
                    bottomRed +=1;
                    vertMiddleRed +=1;
                }else{
                    bottomYellow +=1;
                    vertMiddleYellow +=1;
                }
            }else if(x == bottomRight){
                if (turn%2!=0){
                    bottomRed +=1;
                    rightRed +=1;
                    diagLeftToRightRed +=1;
                }else{
                    bottomYellow +=1;
                    rightYellow +=1;
                    diagLeftToRightYellow +=1;
                }
            }
            checkGame();

    }


    public void imageClicked(View v){

        Log.d("TicTacToes", "Button Pressed");

        ImageView thisImage = findViewById(v.getId());
        selectedSpace(thisImage);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        topLeft = findViewById(R.id.topLeftButton);
        topMiddle = findViewById(R.id.topMiddleButton);
        topRight = findViewById(R.id.topRightButton);
        middleLeft = findViewById(R.id.middleLeftButton);
        middleMiddle = findViewById(R.id.middleMiddleButton);
        middleRight = findViewById(R.id.middleRightButton);
        bottomLeft = findViewById(R.id.bottomLeftButton);
        bottomMiddle = findViewById(R.id.bottomMiddleButton);
        bottomRight = findViewById(R.id.bottomRightButton);

        playAgain = findViewById(R.id.playAgainButton);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeft.setEnabled(true);
                topMiddle.setEnabled(true);
                topRight.setEnabled(true);
                middleLeft.setEnabled(true);
                middleMiddle.setEnabled(true);
                middleRight.setEnabled(true);
                bottomLeft.setEnabled(true);
                bottomMiddle.setEnabled(true);
                bottomRight.setEnabled(true);
                winnerMessage.setEnabled(true);
                playAgain.setEnabled(true);

                topLeft.animate().alpha(0);
                topMiddle.animate().alpha(0);
                topRight.animate().alpha(0);
                middleLeft.animate().alpha(0);
                middleMiddle.animate().alpha(0);
                middleRight.animate().alpha(0);
                bottomLeft.animate().alpha(0);
                bottomMiddle.animate().alpha(0);
                bottomRight.animate().alpha(0);
                winnerMessage.animate().alpha(0);
                playAgain.animate().alpha(0);

                restart();


            }
        });



    }
}
