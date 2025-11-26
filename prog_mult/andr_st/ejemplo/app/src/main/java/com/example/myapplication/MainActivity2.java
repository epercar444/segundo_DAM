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

        TextView tvMensaje = (TextView) findViewById(R.id.mensaje2);
        tvMensaje.setText("Nuevo texto para mostrar");
    }

    // Método para el botón con android:onClick
    public void cambiarTextoXML(View view) {
        TextView tvMensaje = (TextView) findViewById(R.id.mensaje3);
        tvMensaje.setText("Texto cambiado desde XML");
    }
}