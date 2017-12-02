package com.uso.tareacodigo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIniciarJuego,btnPuntaje, btnConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciarJuego = findViewById(R.id.btnIniciarJuego);
        btnConfig = findViewById(R.id.btnConfig);
        btnPuntaje = findViewById(R.id.btnPuntaje);

        SharedPreferences shared = this.getSharedPreferences("datos", Context.MODE_PRIVATE);
        shared.edit().putString("nick","jugador").apply();
        shared.edit().putInt("puntaje1",0).apply();
        shared.edit().putInt("puntaje2",0).apply();
        shared.edit().putInt("puntaje3",0).apply();
        shared.edit().putInt("dificultad",0).apply();

        btnIniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Puntaje.class));
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Configuracion.class));
            }
        });


    }
}
