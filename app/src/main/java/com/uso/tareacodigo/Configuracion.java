package com.uso.tareacodigo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity {

    Button btnGuardarNick,btnGuardarDificultad;
    TextView txtNick;
    RadioGroup grpDificultad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        grpDificultad = findViewById(R.id.rdDificultades);
        txtNick = findViewById(R.id.txtNick);
        btnGuardarNick = findViewById(R.id.btnGuardarNick);
        btnGuardarDificultad = findViewById(R.id.btnGuardarDificultad);

        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        txtNick.setText(pref.getString("nick","def"));




        btnGuardarDificultad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
                switch (grpDificultad.getCheckedRadioButtonId()){
                    case R.id.rbFacil:
                        pref.edit().putInt("dificultad",0).apply();
                        break;
                    case R.id.rbMedia:
                        pref.edit().putInt("dificultad",1).apply();
                        break;
                    case R.id.rbDificil:
                        pref.edit().putInt("dificultad",2).apply();
                        break;
                }
                Toast.makeText(Configuracion.this, "dificultad guardada", Toast.LENGTH_SHORT).show();
            }
        });

        btnGuardarNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
                pref.edit().putString("nick",txtNick.getText().toString()).apply();
                Toast.makeText(Configuracion.this, "nick guardado", Toast.LENGTH_SHORT).show();
            }
        });

        switch (pref.getInt("dificultad",0)){
            case 0:
                grpDificultad.check(R.id.rbFacil);
                break;
            case 1:
                grpDificultad.check(R.id.rbMedia);
                break;
            case 2:
                grpDificultad.check(R.id.rbDificil);
                break;
        }
    }
}
