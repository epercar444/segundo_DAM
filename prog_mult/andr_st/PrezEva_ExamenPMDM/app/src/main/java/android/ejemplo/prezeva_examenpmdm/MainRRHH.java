package android.ejemplo.prezeva_examenpmdm;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainRRHH extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.rrhh);

            GridView miGrid = findViewById(R.id.miGrid);

            Datos[] misDatos = new Datos[]{
                    new Datos("Trabajador-a1", "Empresa1"),
                    new Datos("Trabajador-a2", "Empresa1"),
                    new Datos("Trabajador-a3", "Empresa1"),
                    new Datos("Trabajador-a4", "Empresa1"),
                    new Datos("Trabajador-a5", "Empresa2"),
            };

            // 3. Crear y asignar el adaptador
            Adaptador miAdaptador = new Adaptador(this, misDatos);
            miGrid.setAdapter(miAdaptador);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Empresa de la Torre");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("Menú Principal:",item.toString());
        return super.onOptionsItemSelected(item);
    }
}
