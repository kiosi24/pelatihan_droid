package com.example.d2j_00.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String strShow = "";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShow = (TextView) findViewById(R.id.tambah);

        TransaksiHelper dbHelper = new TransaksiHelper(this);
        List<Transaksi> listTrans = dbHelper.getTransaksi();

        for (int i = 0;i < listTrans.size();i++){
            Transaksi trans = listTrans.get(i);
            strShow += "---------------------------------------\n";
            strShow += trans.nama+" ["+trans.getJenis()+"] : "+trans.jumlah
                        +"\n"+trans.keterangan+"\n";
        }
        txtShow.setText(strShow);
    }

    public void tambah (View view){
        Intent intent = new Intent(this,form_transaksi.class);
        startActivity(intent);
    }
}
