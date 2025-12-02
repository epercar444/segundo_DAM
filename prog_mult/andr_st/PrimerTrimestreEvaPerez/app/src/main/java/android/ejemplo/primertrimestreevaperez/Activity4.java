package android.ejemplo.primertrimestreevaperez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cuarto_layout);

        Button botonVolver = (Button) findViewById(R.id.volver);
        Button botonConsultaLineas = (Button) findViewById(R.id.consultaLineas);
        Button botonConsultaAutobus = (Button) findViewById(R.id.consultaAutobus);
        Button botonConsultaHorario = (Button) findViewById(R.id.consultaHorario);


        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity2.class);
                startActivity(intent);
            }
        });

        botonConsultaLineas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity5.class);
                startActivity(intent);
            }
        });

        botonConsultaAutobus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity6.class);
                startActivity(intent);
            }
        });
        botonConsultaHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity4.this, Activity7.class);
                startActivity(intent);
            }
        });
    }
}
