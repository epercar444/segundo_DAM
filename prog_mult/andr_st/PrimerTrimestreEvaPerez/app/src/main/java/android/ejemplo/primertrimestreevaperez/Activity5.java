package android.ejemplo.primertrimestreevaperez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.quinto_layout);

        Button botonVolver = (Button) findViewById(R.id.volver);
        Button botonSalir = (Button) findViewById(R.id.salir);


        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity5.this, Activity4.class);
                startActivity(intent);
            }
        });
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity5.this, ActivityFinal.class);
                startActivity(intent);
            }
        });
    }
}
