package com.example.d2j_00.daftarharga;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D2J-00 on 16/02/2017.
 */
public class TransaksiHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "pembelian.db";
    public static final int DB_VERSION = 3;

    SQLiteDatabase db;

    public TransaksiHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Transaksi.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Transaksi.SQL_DELETE);
        onCreate(db);
    }

    public void insertTransaksi(String nama, int jenis,int harga, int unit, int total){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Transaksi.COL_NAMA, nama);
        values.put(Transaksi.COL_JENIS, jenis);
        values.put(Transaksi.COL_HARGA, harga);
        values.put(Transaksi.COL_UNIT, unit);
        values.put(Transaksi.COL_TOTAL, total);

        db.insert(Transaksi.TABLE_NAME, null, values);
    }

    public List<Transaksi> getTransaksi(){
        db = getReadableDatabase();
        List<Transaksi> transaksi = new ArrayList<>();
        String [] projection = {Transaksi._ID, Transaksi.COL_NAMA, Transaksi.COL_JENIS,Transaksi.COL_HARGA,
                Transaksi.COL_UNIT, Transaksi.COL_TOTAL};
        String sortOrder = Transaksi._ID;

        Cursor cursor = db.query(Transaksi.TABLE_NAME, projection,null, null, null, null, sortOrder);

        Transaksi newTrans;
        while (cursor.moveToNext()){
            newTrans = new Transaksi(
                    cursor.getString(cursor.getColumnIndex(Transaksi.COL_NAMA)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_JENIS)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_HARGA)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_UNIT)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_TOTAL))
            );

            transaksi.add(newTrans);
        }
        cursor.close();

        return transaksi;
    }


}
