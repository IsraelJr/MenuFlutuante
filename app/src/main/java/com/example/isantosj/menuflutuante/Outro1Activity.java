package com.example.isantosj.menuflutuante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Outro1Activity extends AppCompatActivity {

    TextView txtNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outro1);

        txtNota = (TextView) findViewById(R.id.tvNota);

        if(getIntent() != null)
        {
            txtNota = (TextView) findViewById(R.id.tvNota);
            txtNota.setText(getIntent().getStringExtra("textoExibir"));
        }


    }
}
