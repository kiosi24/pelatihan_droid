package com.example.d2j_00.daftarharga;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by D2J-00 on 16/02/2017.
 */
public class Transaksi implements BaseColumns, Serializable {


    public String nama; //nama transaksi
    public int jenis; // 1 = Honda 2= Yamaha 3= Suzuki 4= Kawasaki 5= Ducati
    public int harga;
    public int unit;
    public int total;

    public Transaksi(String nama, int jenis,int harga, int unit) {
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
        this.unit = unit;
    }

    public Transaksi(String nama, int jenis,int harga, int unit, int total) {
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
        this.unit = unit;
        this.total = total;
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
        return this.nama+": "+this.getJenis()+ " : "+this.harga;
    }

    public static final String TABLE_NAME = "transaksi";
    public static final String COL_NAMA = "nama";
    public static final String COL_JENIS = "type";
    public static final String COL_HARGA = "harga";
    public static final String COL_UNIT = "amount";
    public static final String COL_TOTAL = "total";

    /* query pembuatan dan penghapusan tabel */
    public static final String SQL_CREATE = "create table "+TABLE_NAME
            +" ("+_ID+" integer primary_key,"
            +" "+COL_NAMA+" text,"
            +" "+COL_JENIS+" integer,"
            +" "+COL_HARGA+" integer,"
            +" "+COL_UNIT+" integer,"
            +" "+COL_TOTAL+" integer)";
    public static final String SQL_DELETE = "drop table if exists "+TABLE_NAME;
}
