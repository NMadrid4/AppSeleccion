package com.nicolas.user.seleccionapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nicolas.user.seleccionapp.utilidades.Utilidades;

public class ConexionSQLite extends SQLiteOpenHelper {


    public ConexionSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Utilidades.CREAR_TABLA_JUGADOR);
            db.execSQL("insert into jugador values ('peru1','Pedro Gallese','23 abril, 1990 (28)','23/04/1990','Guardameta','Es un futbolista peruano. Juega como guardameta y su equipo actual es el Tiburones Rojos de Veracruz de la Primera División de México');");
            db.execSQL("insert into jugador values('peru2','Luis Advíncula','23 marzo, 1990 (28)','23/03/1990','Lateral Derecho','Inició su carrera futbolística en las divisiones menores de la academia Esther Grande de Bentín');");
            db.execSQL("insert into jugador values('peru3','Christian Ramos','23 Noviembre, 1988 (29)','23/11/1988','Defensa','Es un futbolista peruano. Juega como defensa central y su equipo actual es el Tiburones Rojos')");
            db.execSQL("insert into jugador values('peru4','Alberto Rodríguez','31 marzo, 1984 (34)','31/03/1984','Defensa','Es un futbolista peruano. Juega de defensa central y su equipo actual es el Junior de Barranquilla')");
            db.execSQL("insert into jugador values('peru5','Miguel trauco','25 agosto, 1992 (25)','25/08/1992','Lateral Izquierdo','Es un futbolista peruano. Juega de lateral izquierdo y su equipo actual es el Flamengo')");
            db.execSQL("insert into jugador values('peru6','Renato Tapia','28 julio, 1995 (22)','28/07/1995','Centrocampista',' Es un futbolista peruano. Juega como mediocentro defensivo y su equipo actual es el Feyenoord')");
            db.execSQL("insert into jugador values('peru7','Yoshimar Yotún','7 abril, 1990 (28)','07/04/1990','Centrocampista','Es un futbolista peruano. Juega como lateral izquierdo y/o centrocampista, y su equipo actual es el Orlando City ')");
            db.execSQL("insert into jugador values('peru8','André Carrillo','14 junio, 1991 (26)','14/06/1991','Delantero',' Es un futbolista peruano. Juega como extremo derecho y su equipo actual es el Watford Football Club')");
            db.execSQL("insert into jugador values('peru9','Christian Cueva','23 noviembre, 1991 (26)','23/11/1991','Centrocampista','Es un futbolista peruano. Juega como mediocentro ofensivo y su equipo actual es el Sao Paulo')");
            db.execSQL("insert into jugador values('peru10','Edison Flores','14 mayo, 1994 (24)','14/05/1994','Centrocampista','Es un futbolista peruano. Juega de centrocampista y su equipo actual es el Aalborg B. K')");
            db.execSQL("insert into jugador values('peru11','Paolo Guerrero','01 enero, 1984 (34)','01/01/1984','Delantero','Es un futbolista peruano. Juega como delantero centro y su equipo es el Clube de Regatas do Flamengo')");
            db.execSQL("insert into jugador values('peru12','Jefferson Farfán','26 octubre, 1984 (33)','26/10/1984','Delantero','Es un futbolista peruano. Juega como delantero en el FC Lokomotiv Moscú')");

        } catch (SQLException e) {
            Log.e("error","error al crear tabla");
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_JUGADOR+"");
        onCreate(db);
    }
}
