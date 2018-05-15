package com.nicolas.user.seleccionapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.nicolas.user.seleccionapp.adaptadores.JugadorAdapter;
import com.nicolas.user.seleccionapp.entidades.JugadorBean;
import com.nicolas.user.seleccionapp.utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<JugadorBean> lstJugador;
    RecyclerView recyclerView;
    JugadorAdapter adapter;
    RecyclerView.LayoutManager lmanager;
    ConexionSQLite conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn = new ConexionSQLite(this,"bd_seleccion",null,1);
        init();
        consultar();
    }

    private void init(){

        recyclerView = findViewById(R.id.rv);

        lstJugador = new ArrayList<>();

        lmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lmanager);

        adapter = new JugadorAdapter(this,lstJugador);
        recyclerView.setAdapter(adapter);


    }
    private  void consultar(){
        try {
            SQLiteDatabase db = conn.getReadableDatabase();
            JugadorBean jugadorBean = null;
            Cursor cursor = db.rawQuery("select * from "+ Utilidades.TABLA_JUGADOR,null);
            while (cursor.moveToNext()){
                jugadorBean = new JugadorBean();
                jugadorBean.setIdJugador(cursor.getString(0));
                jugadorBean.setNombre(cursor.getString(1));
                jugadorBean.setNac(cursor.getString(2));
                jugadorBean.setFec(cursor.getString(3));
                jugadorBean.setPos(cursor.getString(4));
                jugadorBean.setDes(cursor.getString(5));

                lstJugador.add(jugadorBean);
            }
        } catch (Exception e) {
            Log.e("error","error al consultar");
            e.printStackTrace();
        }
    }

}
