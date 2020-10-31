package com.example.guardadordemapas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Reciclar extends AppCompatActivity {
    RecyclerView recicl;
    Conexion salida;
    ArrayList<Ubicacion> lista;
     TextView lo ,la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclar);
        la = findViewById(R.id.altitud);
        lo = findViewById(R.id.longitud);
        salida =  new Conexion(this,"nombredb",null,1);
        lista = new ArrayList<>();
        recicl = findViewById(R.id.recicla);
        recicl.setLayoutManager(new LinearLayoutManager(this));
        listado();
        Adaptador ada = new Adaptador(lista);
        recicl.setAdapter(ada);


    }
    public void listado(){

        SQLiteDatabase db = salida.getReadableDatabase();
        Ubicacion u = null;
        Cursor h = db.rawQuery("SELECT * FROM ubicacion",null);
        while (h.moveToNext()){
            u = new Ubicacion();
            u.setId(h.getInt(0));
            u.setLatitud(h.getString(1));
            u.setLongitud(h.getString(2));
            lista.add(u);
        }




    }




}
