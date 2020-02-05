package com.example.servicios;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

public class Detalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);


    }
    public void onClick(View view) {
        Intent iS = new Intent(this, MisServicio.class);
        stopService(iS);

        startService(iS);
        Toast.makeText(this,"Reproduciendo", Toast.LENGTH_SHORT).show();
    }
    public void onStop(View view) {
        Intent iS = new Intent(this, MisServicio.class);
        stopService(iS);
        Toast.makeText(this,"Pausado", Toast.LENGTH_SHORT).show();
    }



}
