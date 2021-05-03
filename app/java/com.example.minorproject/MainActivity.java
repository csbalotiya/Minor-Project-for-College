package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
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
                    Intent i = new Intent(MainActivity.this, Calculator.class);
                    startActivity(i);
                }else if(x1 > x2){
                    Intent i = new Intent(MainActivity.this, TicTacToe.class);
                    startActivity(i);
                }
                else
                    break;
        }
        return false;
    }



    public void clickOtherBtn(View view) {
        Intent intent2 = new Intent(MainActivity.this,OtherFormulas.class);
        startActivity(intent2);
    }

    public void clickGeometryBtn(View view) {
        Intent intent3 = new Intent(MainActivity.this,geometryFormulas.class);
        startActivity(intent3);
    }

    public void clicedAlgebrabtn(View view) {
        Intent intent4 = new Intent(MainActivity.this,AlgebraFormula.class);
        startActivity(intent4);
    }

    public void clickCalculasBtn(View view) {
        Intent intent5 = new Intent(MainActivity.this,calculasFormulas.class);
        startActivity(intent5);
    }

    public void clickedTrignomertyBtn(View view){
        Intent intent6 = new Intent(MainActivity.this,trignnometryFormulas.class);
        startActivity(intent6);
    }

    public void clickCalcBtn(View view) {
        Intent intent1 = new Intent(MainActivity.this,Calculator.class);
        startActivity(intent1);
    }

    public void shareFunction(View view) {
        String msg = "maths Formulas functionality perfectly sent !!! 👓🎄🎈🎆🎇🧨🎆🧨🎉✔";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,msg);
        intent.setType("text/plain");

        Intent choiser =Intent.createChooser(intent,"share with friends ");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(choiser);
        }
    }


}
