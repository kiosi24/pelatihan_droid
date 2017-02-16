package com.example.d2j_00.daftarharga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class TotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        Intent intent = getIntent();
        // int [] num_barang = new int[6];
        ArrayList<Integer> num_barang = new ArrayList<>();
        num_barang = (ArrayList<Integer>) intent.getSerializableExtra("main.barang.num");


        int [] harga_barang = new int[5];
        harga_barang[0] = 3000000;
        harga_barang[1] = 4000000;
        harga_barang[2] = 1000000;
        harga_barang[3] = 2000000;
        harga_barang[4] = 5000000;

        int [] id_num = {R.id.hon2_num,R.id.yam2_num,R.id.suz2_num,
                R.id.kaw2_num,R.id.duc2_num};
        int [] id_total = {R.id.hon2_total,R.id.yam2_total,R.id.suz2_total,
                R.id.kaw2_total,R.id.duc2_total};

        int total = 0;
        for(int i = 0; i < 5;i ++){
            total += harga_barang[i] * num_barang.get(i);
            ((TextView) findViewById(id_num[i])).setText(Integer.toString(num_barang.get(i)));
            ((TextView) findViewById(id_total[i])).setText(Integer.toString(num_barang.get(i) * harga_barang[i]));
        }

        ((TextView) findViewById(R.id.grand_total)).setText(Integer.toString(total));
    }
}
