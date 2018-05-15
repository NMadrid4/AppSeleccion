package com.nicolas.user.seleccionapp.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nicolas.user.seleccionapp.InfoActivity;
import com.nicolas.user.seleccionapp.R;
import com.nicolas.user.seleccionapp.entidades.JugadorBean;

import java.util.ArrayList;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder> {

    Context contexto;
    ArrayList<JugadorBean> lstJugador;
    private View.OnClickListener listener;

    public JugadorAdapter(Context contexto, ArrayList<JugadorBean> lstJugador) {
        this.contexto = contexto;
        this.lstJugador = lstJugador;
    }

    public ArrayList<JugadorBean> getLstJugador() {
        return lstJugador;
    }


    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_recycler,viewGroup,false);
        return new JugadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final JugadorViewHolder holder, int i) {
        final int id = contexto.getResources().getIdentifier(lstJugador.get(i).getIdJugador(),
                "drawable",contexto.getPackageName());
        holder.img.setImageResource(id);
        holder.nombre.setText(lstJugador.get(i).getNombre());
        holder.nac.setText(lstJugador.get(i).getNac());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(contexto,"Item"+lstJugador.get(holder.getAdapterPosition()).getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(contexto, InfoActivity.class);
                intent.putExtra("img",id);
                intent.putExtra("jugador",lstJugador.get(holder.getAdapterPosition()));
                contexto.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lstJugador.size();
    }



    public static class JugadorViewHolder extends RecyclerView.ViewHolder{
        public ImageView img;
        public TextView nombre;
        public TextView nac;

        public JugadorViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgFoto);
            nombre = itemView.findViewById(R.id.tvNombre);
            nac = itemView.findViewById(R.id.tvNac);
        }
    }

}
