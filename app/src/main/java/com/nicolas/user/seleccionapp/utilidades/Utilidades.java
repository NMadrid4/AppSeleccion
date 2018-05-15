package com.nicolas.user.seleccionapp.utilidades;

public class Utilidades {
    public static final String TABLA_JUGADOR="jugador";
    public static final String CAMPO_ID="idJugador";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_NACIMIENTO="nac";
    public static final String CAMPO_FECHA="fecha";
    public static final String CAMPO_POS="pos";
    public static final String CAMPO_DES="des";


    public static final String CREAR_TABLA_JUGADOR="CREATE TABLE "+TABLA_JUGADOR+"" +
            "("+CAMPO_ID+" TEXT,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_NACIMIENTO+" TEXT," +
            ""+CAMPO_FECHA+" TEXT,"+CAMPO_POS+"TEXT,"+CAMPO_DES+" TEXT)";
}
