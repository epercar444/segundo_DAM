package android.ejemplo.primertrimestreevaperez;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.segundo_layout);

        Button botonConductor = (Button) findViewById(R.id.conductores); //DEFINIMOS LOS BOTONES
        Button botonAdministrador = (Button) findViewById(R.id.administrador);
        Button botonVolver = (Button) findViewById(R.id.volver);


        botonConductor.setOnClickListener(new View.OnClickListener() { //DEFINIMOS DÓNDE QUEREMOS QUE SALGA CUANDO SE PULSE EL BOTÓN
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity4.class);
                startActivity(intent);
            }
        });
        botonAdministrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });
        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    };
}
