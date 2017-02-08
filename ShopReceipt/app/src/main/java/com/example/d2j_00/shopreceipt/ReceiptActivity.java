package com.example.d2j_00.shopreceipt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by D2J-00 on 08/02/2017.
 */
public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        Intent intent = getIntent();
        // int [] num_barang = new int[6];
        ArrayList<Integer> num_barang = new ArrayList<>();
        num_barang = (ArrayList<Integer>) intent.getSerializableExtra("main.barang.num");


        int [] harga_barang = new int[6];
        harga_barang[0] = 3000000;
        harga_barang[1] = 4000000;
        harga_barang[2] = 1000000;
        harga_barang[3] = 2000000;
        harga_barang[4] = 5000000;
        harga_barang[5] = 10000000;

        int [] id_num = {R.id.key2_num,R.id.mouse2_num,R.id.joy2_num,
                R.id.head2_num,R.id.cctv2_num,R.id.hard2_num};
        int [] id_total = {R.id.key2_total,R.id.mouse2_total,R.id.joy2_total,
                R.id.head2_total,R.id.cctv2_total,R.id.hard2_total};

        int total = 0;
        for(int i = 0; i < 6;i ++){
            total += harga_barang[i] * num_barang.get(i);
            ((TextView) findViewById(id_num[i])).setText(Integer.toString(num_barang.get(i)));
            ((TextView) findViewById(id_total[i])).setText(Integer.toString(num_barang.get(i) * harga_barang[i]));
        }

        ((TextView) findViewById(R.id.grand_total)).setText(Integer.toString(total));
    }
}
