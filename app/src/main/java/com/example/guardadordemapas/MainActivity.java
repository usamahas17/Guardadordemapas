package com.example.guardadordemapas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText longitud , latitud;
    Conexion entrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        longitud = findViewById(R.id.entradlongitud);
        latitud =findViewById(R.id.entradlatitud);
        entrada =  new Conexion(this,"nombredb",null,1);


    }
    public void guardar(View v){
        SQLiteDatabase db = entrada.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("latitud",latitud.getText().toString());
        valores.put("longitud",longitud.getText().toString());
        latitud.setText("");
        longitud.setText("");
        Long resul = db.insert("ubicacion","latitud",valores);
        Toast.makeText(this,"campo ingreado "+resul,Toast.LENGTH_LONG).show();


    }
    public void mostrar (View b){
        Intent in = new Intent(getApplicationContext(),Reciclar.class);

        startActivity( in);

    }
}