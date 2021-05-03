package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {

    float x1,x2,y1,y2;
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    Intent i = new Intent(TicTacToe.this, MainActivity.class);
                    startActivity(i);
                }else if(x1 > x2){
                    Intent i = new Intent(TicTacToe.this, MainActivity.class);
                    startActivity(i);
                }
                else
                    break;
        }
        return false;
    }


    boolean gameActive = true;
    //  0 - X
    //  1 - O
    //  2 - Blank
    int activePlayer = 0;
    String winner = null;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int [] winPosition : winPositions){

            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[2]] == gameState[winPosition[1]]
                    && gameState[winPosition[0]] != 2){
                gameActive = false;
                // String winner;
                if(gameState[winPosition[0]] == 0){
                    winner = "🎈🎊 Player 1 X has Won✨";
                }else{
                    winner = "🎈🎊 Player 2 O has Won✨";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }
        boolean emptySqare = true;
        for(int squareState : gameState){
            if(squareState == 2){
                emptySqare = false;
                break;
            }
        }
        if(emptySqare && gameActive){
            gameActive = false;
            winner = "Game draw \n tap to restart";
            TextView status = findViewById(R.id.status);
            status.setText(winner);
        }
    }

    private void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for(int i = 0;i < gameState.length;i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        Intent intent = getIntent();
    }
}
