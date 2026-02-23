package android.ejemplo.readly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainAutores extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.autores);

        View mainView = findViewById(R.id.autores);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        findViewById(R.id.navHome).setOnClickListener(v -> {
            Intent intent = new Intent(MainAutores.this, MainPrincipalLector.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        View autorElisabet = findViewById(R.id.autorElisabet);
        if (autorElisabet != null) {
            autorElisabet.setOnClickListener(v -> {
                Intent intent = new Intent(MainAutores.this, MainVistaPreviaAutores.class);
                startActivity(intent);
            });
        }

        View btnFavorito = findViewById(R.id.navStar);
        if (btnFavorito != null) {
            btnFavorito.setOnClickListener(v -> {
                Intent intent = new Intent(MainAutores.this, MainFavoritos.class);
                startActivity(intent);
            });
        }

        View tvFavoritos = findViewById(R.id.tvFavoritos);
        if (tvFavoritos != null) {
            tvFavoritos.setOnClickListener(v -> {
                Intent intent = new Intent(MainAutores.this, MainFavoritos.class);
                startActivity(intent);
            });
        }
    }
}