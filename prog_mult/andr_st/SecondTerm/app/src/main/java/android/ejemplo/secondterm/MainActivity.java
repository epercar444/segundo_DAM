package android.ejemplo.secondterm;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("administrador", item.toString());
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuelemento, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Log.i("administrador", item.toString());
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        /*TextView elemento = (TextView) findViewById(R.id.texto);
        registerForContextMenu(elemento);*/
        Datos[] datos = new Datos[]{
                new Datos("Cien Años de Soledad", "Gabriel García Márquez"),
                new Datos("Frankenstein", "Mary Shelley"),
                new Datos("El Principito", "Antoine de Saint-Exupéry"),
                new Datos("Don Quijote de la Mancha", "Miguel de Cervantes"),
                new Datos("El Señor de los Anillos", "J.R.R. Tolkien"),
                new Datos("El Hobbit", "J.R.R. Tolkien"),
                new Datos("El Silmarillion", "J.R.R. Tolkien"),
                new Datos("Mujercitas", "Louisa May Alcott"),
                new Datos("Orgullo y Prejuicio", "Jane Austen"),
                new Datos("Los Pilares de la Tierra", "Ken Follett"),
                new Datos("El Alquimista", "Paulo Coelho"),
                new Datos("Odisea", "Homero"),
        };
        ListView listado = (ListView) findViewById(R.id.miLista);
        Adaptador miAdaptador = new Adaptador(this, datos);
        listado.setAdapter(miAdaptador);
        registerForContextMenu(listado);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Pulsado", "Elemento pulsado: "+position);
                Log.i("Pulsado", "Elemento pulsado: "+(Datos) parent.getItemAtPosition(position));
            }
        });

    }
}
