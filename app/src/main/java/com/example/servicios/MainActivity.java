package com.example.servicios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Song> list=new ArrayList<>();

        list.add(new Song(1,"01","01 - Waiting For Love"));
        list.add(new Song(2,"02","02 - Talk To Myself"));
        list.add(new Song(1,"01","01 - Waiting For Love"));
        list.add(new Song(2,"02","02 - Talk To Myself"));
        list.add(new Song(1,"01","01 - Waiting For Love"));
        list.add(new Song(2,"02","02 - Talk To Myself"));
        RecyclerView recyclerView=findViewById(R.id.songs);
       final Adaptador adaptador=new Adaptador(this,list);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(adaptador);
        final Context context=this;
        adaptador.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(context,Detalle.class);
                startActivityForResult(inten,0);


            }
        });
    }
}
