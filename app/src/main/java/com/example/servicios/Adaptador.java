package com.example.servicios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder>{

    private LayoutInflater inflador; //Crea Layouts a partir del XML
    //protected Vector<Libro> vectorLibros; //Vector con libros a visualizar
    private ArrayList<Song> list;
    private Context contexto;
    private View.OnClickListener onClickListener;



    public  void setOnItemClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public Adaptador(Context contexto, ArrayList<Song> list) {
        inflador = (LayoutInflater) contexto
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
        this.contexto = contexto;
    }

    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.txtName);


        }
    }
    // Creamos el ViewHolder con las vista de un elemento sin personalizar
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflamos la vista desde el xml
        View v = inflador.inflate(R.layout.song_selector, null);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        Song song = list.get(posicion);
        //contexto.getApplicationContext().grantUriPermission("", Uri.parse(uri.getUri()), Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);


        holder.name.setText(song.getName());
//revoke permisions
        //contexto.getApplicationContext().revokeUriPermission(uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);

    }

    // Usando como base el ViewHolder y lo personalizamos

    // Indicamos el número de elementos de la lista
    @Override public int getItemCount() {
        return list.size();
    }

}
