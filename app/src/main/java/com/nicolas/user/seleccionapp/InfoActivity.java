package com.nicolas.user.seleccionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicolas.user.seleccionapp.entidades.JugadorBean;

public class InfoActivity extends AppCompatActivity {
    private TextView nom,fec,pos,des;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        init();
    }

    private void init() {
        nom = findViewById(R.id.tvInfoNom);
        fec = findViewById(R.id.tvFecha);
        pos = findViewById(R.id.tvPos);
        des = findViewById(R.id.tvDescripcion);
        img = findViewById(R.id.imgInfo);


        JugadorBean jugadorBean = (JugadorBean) getIntent().getExtras().get("jugador");
        nom.setText(jugadorBean.getNombre());
        fec.setText(jugadorBean.getFec());
        pos.setText(jugadorBean.getPos());
        des.setText(jugadorBean.getDes());

        int id = getIntent().getExtras().getInt("img");
        img.setImageResource(id);


    }
}
