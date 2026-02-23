package android.ejemplo.readly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainLibrosLeyendo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.libros_leyendo);

        View mainView = findViewById(R.id.librosLeyendo);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                Intent intent = new Intent(MainLibrosLeyendo.this, MainPrincipalLector.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            });
        }

        View navHome = findViewById(R.id.navHome);
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                Intent intent = new Intent(MainLibrosLeyendo.this, MainPrincipalLector.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            });
        }

        View libroItem2 = findViewById(R.id.libroItem2);
        if (libroItem2 != null) {
            libroItem2.setOnClickListener(v -> {
                Intent intent = new Intent(MainLibrosLeyendo.this, MainVistaPrincipalLibro.class);
                startActivity(intent);
            });
        }

        View btnFavorito = findViewById(R.id.navStar);
        if (btnFavorito != null) {
            btnFavorito.setOnClickListener(v -> {
                Intent intent = new Intent(MainLibrosLeyendo.this, MainFavoritos.class);
                startActivity(intent);
            });
        }

        View tvFavoritos = findViewById(R.id.tvFavoritos);
        if (tvFavoritos != null) {
            tvFavoritos.setOnClickListener(v -> {
                Intent intent = new Intent(MainLibrosLeyendo.this, MainFavoritos.class);
                startActivity(intent);
            });
        }
    }
}