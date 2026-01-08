package android.ejemplo.es;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedIns) {
        super.onCreate(savedIns);
        setContentView(R.layout.activity_actividad2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent ejemplo= new Intent(Intent.ACTION_VIEW);
        ejemplo.setData(Uri.parse("https://www.google.es"));
        startActivity(ejemplo);

    }
}
