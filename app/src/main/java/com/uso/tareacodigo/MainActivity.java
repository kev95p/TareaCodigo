package com.uso.tareacodigo;

import android.content.Intent;
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

        btnIniciarJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPuntaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
