package android.ejemplo.prezeva_examenpmdm;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainTrabajador extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.trabajador);

        Datos[] datos = new Datos[]{
                new Datos("Entrada", "5/2/2026 - 8:02"),
                new Datos("Salida", "5/2/2026 - 14:32"),
                new Datos("Entrada", "5/2/2026 - 7:52"),
                new Datos("Salida", "5/2/2026 - 14:35"),
                new Datos("Entrada", "5/2/2026 - 7:55"),
        };
        ListView listado = (ListView) findViewById(R.id.miLista);
        android.ejemplo.prezeva_examenpmdm.Adaptador miAdaptador = new android.ejemplo.prezeva_examenpmdm.Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
        registerForContextMenu(listado);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Empresa de la Torre");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("Menú Principal:",item.toString());
        return super.onOptionsItemSelected(item);
    }



}
