package com.example.myapplication;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
        private static final int REQUEST_CAMERA_PERMISSION = 1;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Verificar si el permiso de cámara está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }
    }

    private void abrirCamara() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); // Acción para abrir la cámara
        startActivity(intent);  // Lanzar la actividad de la cámara
    }*/
       /* EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        };*/

    @Override
    protected void onCreate(Bundle savedIns) {
        super.onCreate(savedIns);
        setContentView(R.layout.activity_main);

        /*Intent ejemplo = new Intent(this, MainActivity2.class);
        startActivity(ejemplo);
        Intent ejemplo1 = new Intent(Intent.ACTION_VIEW);
        ejemplo1.setData(Uri.parse("http://www.google.es"));
        startActivity(ejemplo1);
        Intent ejemplo3 = new Intent(Intent.ACTION_CALL);
        ejemplo3.setData(Uri.parse("tel:685339172"));
        startActivity(ejemplo3);
        // Intent ejemplo4 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // startActivity(ejemplo4);

         */
    }
    /*private static final int REQUEST_CAMERA_PERMISSION = 1;*/



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onStart() {
        super.onStart();
        Intent ejemplo = new Intent(this, MainActivity2.class);
        ejemplo.putExtra("Surname", "Pérez");
        startActivity(ejemplo);

    }





}
        /*setContentView(R.layout.activity_main);
        // Verificar si el permiso de cámara está concedido
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Si ya tiene permiso, abrir la cámara
            abrirCamara();
        } else {
            // Si no tiene permiso, solicitarlo
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.CAMERA},
                    REQUEST_CAMERA_PERMISSION);
        }
    }*/


    /*Log.i("Entrada", "Estoy en el activity main");

    Intent ejemplo = new Intent(Intent.ACTION_CALL);
        ejemplo.setData(Uri.parse("tel:685339172"));

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
    CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
        startActivity(ejemplo);
    } else {
        requestPermissions(new String[]{CALL_PHONE}, 1);
    }
}*/




   /* int permissionCheck = ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.CAMERA);

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_CAMERA: {
                if (grantResults.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    CÓDIGO SI PERMISO DADO
                }
                else {
                    CÓDIGO SI PERMISO NO DADO
                }
            }
        }
    }*/ //prueba permiso


