package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedIns) {
        super.onCreate(savedIns);
        setContentView(R.layout.activity_actividad1);
        Bundle b = new Bundle(getIntent().getExtras());
        Log.i("Datos:",b.getString("Surname"));
    }
}
