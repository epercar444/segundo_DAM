package android.ejemplo.readly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainAnadirAnotacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.anadir_anotacion);

        View mainView = findViewById(R.id.anadirAnotacion);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        View navHome = findViewById(R.id.navHome);
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(MainAnadirAnotacion.this, MainPrincipalLector.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            });
        }

        View btnAnadirAnotacion = findViewById(R.id.btnAnadirAnotacion);
        if (btnAnadirAnotacion != null) {
            btnAnadirAnotacion.setOnClickListener(v -> {
                Toast.makeText(MainAnadirAnotacion.this, "Anotación añadida correctamente", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainAnadirAnotacion.this, MainVistaPrincipalLibro.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            });
        }

        View btnFavorito = findViewById(R.id.navStar);
        if (btnFavorito != null) {
            btnFavorito.setOnClickListener(v -> {
                Intent intent = new Intent(MainAnadirAnotacion.this, MainFavoritos.class);
                startActivity(intent);
            });
        }
    }
}