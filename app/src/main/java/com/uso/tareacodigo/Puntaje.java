package com.uso.tareacodigo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Puntaje extends AppCompatActivity {

    ListView lstPuntaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);

        String puntajes[] = new String[]{"primero: "+pref.getInt("puntaje1",0)
                ,"segundo: "+pref.getInt("puntaje2",0),"tercero: "+pref.getInt("puntaje3",0)};

        lstPuntaje = findViewById(R.id.lstPuntaje);

        lstPuntaje.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,puntajes));
    }
}
