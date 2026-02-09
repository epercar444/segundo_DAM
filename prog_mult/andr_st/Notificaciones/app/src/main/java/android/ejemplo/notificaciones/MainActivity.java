package android.ejemplo.notificaciones;

import android.content.pm.PackageManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    // Canal de notificaciones
    private static final String CHANNEL_ID = "canal_basico_1";

    // ID de la notificación
    private static final int NOTIFICATION_ID = 101;

    // Código para pedir permiso
    private static final int REQUEST_NOTIFICATION_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear canal
        createNotificationChannel();

        // Pedir permiso
        pedirPermisoNotificaciones();

        Button btnNotificar = findViewById(R.id.btnNotificar);

        btnNotificar.setOnClickListener(v -> lanzarNotificacion());
    }

    // Crear canal (Android 8+)
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Notificaciones Básicas";
            String description = "Canal para aprender notificaciones";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel =
                    new NotificationChannel(CHANNEL_ID, name, importance);

            channel.setDescription(description);

            NotificationManager manager =
                    getSystemService(NotificationManager.class);

            manager.createNotificationChannel(channel);
        }
    }

    // Pedir permiso (Android 13+)
    private void pedirPermisoNotificaciones() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                        this,
                        new String[]{android.Manifest.permission.POST_NOTIFICATIONS},
                        REQUEST_NOTIFICATION_PERMISSION
                );
            }
        }
    }

    // Lanzar notificación
    private void lanzarNotificacion() {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Readly")
                        .setContentText("Bienvenido a Readly.¿Listo para guardar tus libros favoritos?")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

        NotificationManagerCompat manager =
                NotificationManagerCompat.from(this);

        // Comprobar permiso antes de notificar
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this,
                    "No hay permiso para notificaciones",
                    Toast.LENGTH_SHORT).show();

            return;
        }

        manager.notify(NOTIFICATION_ID, builder.build());
    }

    // Resultado del permiso
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);

        if (requestCode == REQUEST_NOTIFICATION_PERMISSION) {

            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this,
                        "Permiso concedido",
                        Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this,
                        "Permiso denegado",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
