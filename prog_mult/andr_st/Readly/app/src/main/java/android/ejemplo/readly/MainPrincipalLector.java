package android.ejemplo.readly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainPrincipalLector extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.principal_lector);

        View mainView = findViewById(R.id.principalLector);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        View headerAutores = findViewById(R.id.headerAutores);
        if (headerAutores != null) {
            headerAutores.setOnClickListener(v -> {
                Intent intent = new Intent(MainPrincipalLector.this, MainAutores.class);
                startActivity(intent);
            });
        }

        View autorElisabet = findViewById(R.id.autorElisabet);
        if (autorElisabet != null) {
            autorElisabet.setOnClickListener(v -> {
                Intent intent = new Intent(MainPrincipalLector.this, MainVistaPreviaAutores.class);
                startActivity(intent);
            });
        }

        View bannerIA = findViewById(R.id.bannerIA);
        if (bannerIA != null) {
            bannerIA.setOnClickListener(v -> {
                Intent intent = new Intent(MainPrincipalLector.this, MainIA.class);
                startActivity(intent);
            });
        }

        View headerLibrosLeyendo = findViewById(R.id.headerLibrosLeyendo);
        if (headerLibrosLeyendo != null) {
            headerLibrosLeyendo.setOnClickListener(v -> {
                Intent intent = new Intent(MainPrincipalLector.this, MainLibrosLeyendo.class);
                startActivity(intent);
            });
        }
    }
}