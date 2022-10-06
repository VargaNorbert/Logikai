package com.example.logikai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnPlusz;
    private Button btnMinusz;
    private Button btnTippel;
    private ImageView hp1;
    private ImageView hp2;
    private ImageView hp3;
    private ImageView hp4;
    private TextView tippErtek;

    private ImageView[] eletek;

    private int tipp;

    private int gondolt;

    private Random rnd;

    private int elet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        addListener();
    }

    private void addListener(){
        btnPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tipp<10){
                    tipp++;
                    tippErtek.setText(String.valueOf(tipp));
                }else{
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet nagyobb, mint 10", Toast.LENGTH_SHORT).show();
                }



            }
        });

        btnMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tipp>1){
                    tipp--;
                    tippErtek.setText(String.valueOf(tipp));
                }else{
                    Toast.makeText(MainActivity.this, "A gondolt szám nem lehet kisebb, mint 1", Toast.LENGTH_SHORT).show();
                }



            }
        });

        btnTippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tipp<gondolt){
                    eletCsokkent();
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                }else if(tipp>gondolt){
                    eletCsokkent();
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();
                }else{
                   // TODO: Győzelem
                }

            }
        });
    }

    private void init(){
        btnPlusz = findViewById(R.id.btnPlusz);
        btnMinusz = findViewById(R.id.btnMinusz);
        btnTippel = findViewById(R.id.btnTippel);
        hp1= findViewById(R.id.hp_1);
        hp2= findViewById(R.id.hp_2);
        hp3= findViewById(R.id.hp_3);
        hp4= findViewById(R.id.hp_4);

        tippErtek= findViewById(R.id.tippErteke);

        tipp=1;
        rnd= new Random();
        gondolt=rnd.nextInt(10)+1;

        elet = 4;

        eletek=new ImageView[]{hp1,hp2,hp3,hp4};
    }

    private void eletCsokkent(){
        elet--;

        eletek[elet].setImageResource(R.drawable.heart1);

        if (elet==0){
            // TODO: Vereség
        }
    }


    private void eletCsokkentsw(){
        elet--;

        switch (elet){
            case 3:
                hp4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                hp3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                hp2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                hp1.setImageResource(R.drawable.heart1);
                break;
        }

        if (elet==0){
            // TODO: Vereség
        }
    }
}