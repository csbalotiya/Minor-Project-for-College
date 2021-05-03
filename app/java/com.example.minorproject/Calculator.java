package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnAdd,btnMinus,btnMul,btnDivide,btnDot,btnEqual;
    Button btnClear;
    EditText ed1;
    float res1,res2;
    boolean Add,Sub,Mul,Div;


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
                    Intent i = new Intent(Calculator.this, MainActivity.class);
                    startActivity(i);
                }else if(x1 > x2){
                    Intent i = new Intent(Calculator.this, MainActivity.class);
                    startActivity(i);
                }
                else
                    break;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Intent intent = getIntent();


        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnDot = (Button)findViewById(R.id.btnDot);
        btnClear = (Button)findViewById(R.id.btnClear);
        ed1 = (EditText)findViewById(R.id.editText);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"0");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+".");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1 == null){
                    ed1.setText("");
                }
                else{
                    res1 = Float.parseFloat(ed1.getText()+"");
                    Add = true;
                    ed1.setText(null);
                }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1 == null){
                    ed1.setText("");
                }
                else{
                    res1 = Float.parseFloat(ed1.getText()+"");
                    Sub = true;
                    ed1.setText(null);
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1 == null){
                    ed1.setText("");
                }
                else{
                    res1 = Float.parseFloat(ed1.getText()+"");
                    Mul = true;
                    ed1.setText(null);
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1 == null){
                    ed1.setText("");
                }
                else{
                    res1 = Float.parseFloat(ed1.getText()+"");
                    Div = true;
                    ed1.setText(null);
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res2 = Float.parseFloat(ed1.getText()+"");
                if (Add == true){
                    ed1.setText(res1+res2+"");
                    Add = false;
                }
                if (Sub == true){
                    ed1.setText(res1-res2+"");
                    Sub = false;
                }
                if (Mul == true){
                    ed1.setText(res1*res2+"");
                    Mul = false;
                }
                if (Div == true){
                    ed1.setText(res1/res2+"");
                    Div = false;
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
            }
        });

    }

}
