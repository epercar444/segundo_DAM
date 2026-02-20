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

public class MainAnadirComentario extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.anadir_comentario);

        View mainView = findViewById(R.id.anadirComentario);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        findViewById(R.id.navHome).setOnClickListener(v -> {
            Intent intent = new Intent(MainAnadirComentario.this, MainPrincipalLector.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });

        findViewById(R.id.btnEnviarComentario).setOnClickListener(v -> {
            Toast.makeText(MainAnadirComentario.this, "Comentario en revisión", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainAnadirComentario.this, MainVistaPreviaAutores.class);
            startActivity(intent);
        });
    }
}
