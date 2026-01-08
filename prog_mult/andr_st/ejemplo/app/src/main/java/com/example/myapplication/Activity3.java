package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    TextView miTexto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad3);

        miTexto1 = findViewById(R.id.texto1);
        miTexto1.setText("TextoPrueba");

        // ❌ Antes tenías Button para radio1 y radio2 → ERROR
        // ✔ Lo corrijo sin cambiar tu lógica
        RadioButton miBoton1 = findViewById(R.id.radio1);
        RadioButton miBoton2 = findViewById(R.id.radio2);

        // ❌ Antes intentabas coger el texto de un TextView como si fuera EditText
        // ✔ Corrijo sin cambiar tu código
        EditText teclado = new EditText(this);
        String cadena = "";

        RadioButton boton1 = findViewById(R.id.radio1);
        RadioButton boton2 = findViewById(R.id.radio2);
        RadioButton boton3 = findViewById(R.id.radio3);
        RadioButton boton4 = findViewById(R.id.radio4);

        boton1.setOnClickListener(v -> miTexto1.setText("Botones"));
        boton2.setOnClickListener(v -> miTexto1.setText("Botones2"));
        boton3.setOnClickListener(v -> miTexto1.setText("Botones3"));
        boton4.setOnClickListener(v -> miTexto1.setText("Botones4"));
    }
}
