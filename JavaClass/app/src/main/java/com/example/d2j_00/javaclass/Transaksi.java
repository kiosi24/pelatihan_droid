package com.example.d2j_00.javaclass;

import java.util.ArrayList;

/**
 * Created by D2J-00 on 31/01/2017.
 */
public class Transaksi {

    private ArrayList<Barang> listBarang = new ArrayList<>();

    public void addBarang(Barang barang){
        this.listBarang.add(barang);
    }

    public int totalTransaksi(){
        int hasil = 0;
        for (int i=0; i < listBarang.size(); i++){
            hasil += listBarang.get(i).getHarga();
        }
        return hasil;
    }

    public String printTransaksi(){
        String text = "Barang yang dibeli pada transaksi ini adalah:\n";
        text += "\n--------------------------------------------\n";
        for(int i = 0; i < listBarang.size(); i++){
            text += listBarang.get(i).toString();
        }
        text += "----------------------------------------------\n";
        text += "Total Pembelian: "+totalTransaksi()+"\n";
        text += "----------------------------------------------\n";
        return text;
    }

    public double averageTransaksi(){
        double hasil = 0;

        //isi dengan kode untuk mendapatkan rata2 dari transaksi
        for (int i=0; i < listBarang.size(); i++) {
            hasil += listBarang.get(i).getHarga();
        }

        hasil = hasil / listBarang.size();
        return hasil;
    }

    public String maxBarang(){
        Barang max;

        // isi dengan kode untuk mencari barang dengan harga termahal
        // kemudian masukan nama barangnya pada variabel di bawah ini.
        max = listBarang.get(0);
        for (int i = 0; i < listBarang.size(); i++){
            if(listBarang.get(i).getHarga() > max.getHarga()){
                max =listBarang.get(i);
            }
        }

        String namaBarang = max.getNama();
        String text = "Barang termahal pada transaksi adalah "+namaBarang;
        return text;
    }

}

