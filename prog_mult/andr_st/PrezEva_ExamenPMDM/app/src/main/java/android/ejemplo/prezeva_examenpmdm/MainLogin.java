package android.ejemplo.prezeva_examenpmdm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainLogin extends AppCompatActivity {
    private static final String CHANNEL_ID = "canal_basico_1";
    private static final int NOTIFICATION_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        EditText nombreUsuario = findViewById(R.id.usuario);
        Button btnAcceso = findViewById(R.id.btn_acceso);

        createNotificationChannel();

        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreUsuario.getText().toString().toLowerCase().trim();

                if (nombre.equals("administrador")) {
                    Toast.makeText(getApplicationContext(), "Iniciando sesión como RRHH", Toast.LENGTH_LONG).show();
                    lanzarNotificacion();
                    startActivity(new Intent(MainLogin.this, MainRRHH.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Iniciando sesión como trabajador", Toast.LENGTH_LONG).show();
                    lanzarNotificacion();
                    startActivity(new Intent(MainLogin.this, MainTrabajador.class));
                }
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificaciones Básicas";
            String description = "Canal para aprender notificaciones";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void lanzarNotificacion() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Empresa de la Torre")
                .setContentText("Bienvenido, has iniciado sesión con éxito.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

    }
}