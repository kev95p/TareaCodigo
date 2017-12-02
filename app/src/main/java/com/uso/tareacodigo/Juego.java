package com.uso.tareacodigo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Juego extends AppCompatActivity {

    TextView lblIntentos,lblNumero;
    EditText txtNumero;
    Button btnResponder;
    int intentos;
    int numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        lblIntentos = findViewById(R.id.lblIntento);
        lblNumero = findViewById(R.id.lblRespuesta);
        txtNumero = findViewById(R.id.txtNumero);
        btnResponder = findViewById(R.id.btnResponder);

        intentos =0;

        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);

        Random aleatorio = new Random(System.currentTimeMillis());

        switch (pref.getInt("dificultad",0)){
            case 0:
                numero = aleatorio.nextInt(50);
                break;
            case 1:
                numero = aleatorio.nextInt(100);
                break;
            case 2:
                numero = aleatorio.nextInt(150);
                break;
        }

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
                if(txtNumero.getText().toString().equals("")){
                    return;
                }
                int respuesta = Integer.parseInt(txtNumero.getText().toString());
                if(respuesta == numero){
                    Toast.makeText(Juego.this, "felicidades adivinastes el numero", Toast.LENGTH_SHORT).show();
                    lblNumero.setText(String.valueOf(numero));
                    if(intentos < pref.getInt("puntaje1",0)){
                        pref.edit().putInt("puntaje1",intentos).apply();
                    }
                    else if(intentos < pref.getInt("puntaje2",0)){
                        pref.edit().putInt("puntaje2",intentos).apply();
                    }
                    else if(intentos < pref.getInt("puntaje3",0)){
                        pref.edit().putInt("puntaje3",intentos).apply();
                    }
                }
                else{
                    intentos ++ ;
                    lblIntentos.setText("intentos:"+intentos);
                    txtNumero.setText("");
                }
            }
        });

    }
}
