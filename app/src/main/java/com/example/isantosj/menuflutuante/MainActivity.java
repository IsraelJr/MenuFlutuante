package com.example.isantosj.menuflutuante;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton float_plus, float_outro1, float_outro2;
    Animation floatOpen, floatClose, floatRotClockwise, floatRotAntiClockwise;
    boolean isOpen = false;

    EditText txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float_plus = (FloatingActionButton) findViewById(R.id.float_plus);
        float_outro1 = (FloatingActionButton) findViewById(R.id.float_outro1);
        float_outro2 = (FloatingActionButton) findViewById(R.id.float_outro2);

        floatOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.float_open);
        floatClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.float_close);
        floatRotClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        floatRotAntiClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        float_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isOpen)
                {
                    float_outro1.startAnimation(floatClose);
                    float_outro2.startAnimation(floatClose);
                    float_plus.startAnimation(floatRotAntiClockwise);
                    float_outro1.setClickable(false);
                    float_outro2.setClickable(false);
                    isOpen = false;
                }
                else
                {
                    float_outro1.startAnimation(floatOpen);
                    float_outro2.startAnimation(floatOpen);
                    float_plus.startAnimation(floatRotClockwise);
                    float_outro1.setClickable(true);
                    float_outro2.setClickable(true);
                    isOpen = true;
                }
            }
        });

        txtHello = (EditText) findViewById(R.id.tvHello);
    }

    public void abrirOutro1(View view){
        Intent intOutro1 = new Intent(this, Outro1Activity.class);
        intOutro1.putExtra("textoExibir", txtHello.getText().toString());
        startActivity(intOutro1);
//        finish();
    }
}
