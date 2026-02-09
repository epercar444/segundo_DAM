package android.ejemplo.prezeva_examenpmdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaptadorRRHH extends ArrayAdapter<Datos> {
    private Datos[] datos;

    public AdaptadorRRHH(Context context, Datos[] datos){
        super(context, R.layout.elemento, datos);
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View elemento = convertView;
        if (elemento == null) {
            LayoutInflater mostrado = LayoutInflater.from(getContext());
            elemento = mostrado.inflate(R.layout.elemento, parent, false);
        }
        TextView texto1 = (TextView) elemento.findViewById(R.id.miTexto1);
        texto1.setText(datos[position].getTexto1());
        TextView texto2 = (TextView) elemento.findViewById(R.id.miTexto2);
        texto2.setText(datos[position].getTexto2());
        return elemento;
    }
}