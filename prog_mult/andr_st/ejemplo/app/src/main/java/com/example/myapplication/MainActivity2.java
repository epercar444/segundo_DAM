package com.example.myapplication;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedIns) {
        super.onCreate(savedIns);
        setContentView(R.layout.activity_actividad1);
        Bundle b = new Bundle(getIntent().getExtras());
        Log.i("Datos:",b.getString("Surname"));

        TextView miTexto = (TextView) findViewById(R.id.texto);
        miTexto.setText(("Nuevo texto para mostrar"));
        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto.startAnimation(miAnimacion);
        //miTexto.setTextColor(getResources().getColor(R.color.principal));
       // Typeface miFuente = Typeface.createFromAsset((getAssets()),"fonts/karla.ttf");
        //miTexto.setTypeface(miFuente);
    }
  /*@Override
  protected void onCreate(Bundle savedIns) {
      super.onCreate(savedIns);
      setContentView(R.layout.prueba1_linearlayout);
  }*/
}

