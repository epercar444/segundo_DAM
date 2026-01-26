package android.ejemplo.notificaciones;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Identificador único para el canal (obligatorio en API 26+)
    private static final String CHANNEL_ID = "canal_basico_1";
    // ID único para la notificación (para actualizarla o cancelarla luego)
    private static final int NOTIFICATION_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Crear el canal de notificaciones (Solo necesario en Android 8.0+)
        createNotificationChannel();

        Button btnNotificar = findViewById(R.id.btnNotificar);
        btnNotificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarNotificacion();
            }
        });
    }

    private void createNotificationChannel() {
        // Solo se crea el canal si la versión es Android 8.0 (API 26) o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notificaciones Básicas";
            String description = "Canal para aprender notificaciones";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Registrar el canal en el sistema
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void lanzarNotificacion() {
        // 2. Construir la notificación
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info) // Icono del sistema (puedes usar el tuyo propio)
                .setContentTitle("¡Hola Mundo!")
                .setContentText("Esta es tu primera notificación en Android.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true); // Se cierra al tocarla
        // 3. Mostrar la notificación
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // Chequeo de permisos para Android 13+ (necesario para evitar crashes en versiones nuevas)
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // Si no hay permiso, aquí deberíamos pedirlo.
            // Para este ejemplo básico, simplemente retornamos.
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}



        /*Toast toast = Toast.makeText(getApplicationContext(),"Mensaje desde Toast",Toast.LENGTH_LONG);
        toast.show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Ejemplo de diálogo")
                .setTitle("Título del diálogo")
                .setIcon(R.mipmap.ic_launcher);
        AlertDialog dialog = builder.create();
        dialog.show();
        builder.setMessage("Ejemplo de diálogo")
                .setTitle("Título del diálogo")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Primero", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Elegido","Positivo");
                    }
                })
                .setNegativeButton("Segundo",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Elegido","Negativo");
                    }
                })
                .setNeutralButton("Tercero", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("Elegido","Neutro");
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();*/