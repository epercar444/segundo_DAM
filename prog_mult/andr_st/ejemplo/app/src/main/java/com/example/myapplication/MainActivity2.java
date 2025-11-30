package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedIns) {
        super.onCreate(savedIns);
        setContentView(R.layout.actividad3);  // Llamada al XML

        TextView tvMensaje = (TextView) findViewById(R.id.texto1);
        tvMensaje.setText("Nuevo texto para mostrar");

    }
}