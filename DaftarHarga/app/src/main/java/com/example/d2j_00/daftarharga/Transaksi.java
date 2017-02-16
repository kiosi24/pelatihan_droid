package com.example.d2j_00.daftarharga;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by D2J-00 on 16/02/2017.
 */
public class Transaksi implements BaseColumns, Serializable {


    public String nama; //nama transaksi
    public int jenis; // 1 = Honda 2= Yamaha 3= Suzuki 4= Kawasaki 5= Ducati
    public int unit;
    public String keterangan;

    public Transaksi(String nama, int jenis, int unit) {
        this.nama = nama;
        this.jenis = jenis;
        this.unit = unit;
    }

    public Transaksi(String nama, int jenis, int unit, String keterangan) {
        this.nama = nama;
        this.jenis = jenis;
        this.unit = unit;
        this.keterangan = keterangan;
    }

    public String getJenis(){
        if (this.jenis == 1){
            return "Honda";
        }
        else if (this.jenis == 2){
            return "Yamaha";
        }
        else if (this.jenis == 3){
            return "Suzuki";
        }
        else if (this.jenis == 4){
            return "Kawasaki";
        }
        return "Ducati";
    }


    @Override
    public String toString(){
        return this.nama+": "+this.unit;
    }

    public static final String TABLE_NAME = "transaksi";
    public static final String COL_NAMA = "nama";
    public static final String COL_JENIS = "type";
    public static final String COL_JUMLAH = "amount";
    public static final String COL_KETERANGAN = "keterangan";

    /* query pembuatan dan penghapusan tabel */
    public static final String SQL_CREATE = "create table "+TABLE_NAME
            +" ("+_ID+" integer primary_key,"
            +" "+COL_NAMA+" text,"
            +" "+COL_JENIS+" integer,"
            +" "+COL_JUMLAH+" integer,"
            +" "+COL_KETERANGAN+" text)";
    public static final String SQL_DELETE = "drop table if exists "+TABLE_NAME;
}
