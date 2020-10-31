package com.example.guardadordemapas;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderadadp> {
    ArrayList<Ubicacion> listaubicacion;
    public  Adaptador(ArrayList<Ubicacion> unamas){
        this.listaubicacion = unamas;

    }
    @NonNull
    @Override
    public Adaptador.ViewHolderadadp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View k = LayoutInflater.from(parent.getContext()).inflate(R.layout.registro,null,false);
        return new ViewHolderadadp(k);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolderadadp holder, final int position) {
        holder.longitud.setText(listaubicacion.get(position).getLongitud());
        holder.latitud.setText(listaubicacion.get(position).getLatitud());
        holder.bot.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intento = new Intent(view.getContext(),Mapa.class);
                intento.putExtra("latitud",listaubicacion.get(position).getLatitud());
                intento.putExtra("longitud",listaubicacion.get(position).getLongitud());
                view.getContext().startActivity(intento);
            }
        });






    }

    @Override
    public int getItemCount() {
        return listaubicacion.size();
    }public  class ViewHolderadadp extends RecyclerView.ViewHolder{
        TextView longitud,latitud;
        Button bot;


        public ViewHolderadadp(View item){
            super(item);
            longitud = item.findViewById(R.id.longitud);
            latitud = item.findViewById(R.id.altitud);
            bot = item.findViewById(R.id.boton);

        }
    }

    }

