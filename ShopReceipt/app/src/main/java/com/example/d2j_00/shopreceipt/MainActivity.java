package com.example.d2j_00.shopreceipt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void  printReceipt(View view){
        String [] barang = new String[6];
        ArrayList<Integer> num_barang = new ArrayList<>();


        barang[0] = ((EditText) findViewById(R.id.key_num)).getText().toString();
        barang[1] = ((EditText) findViewById(R.id.mouse_num)).getText().toString();
        barang[2] = ((EditText) findViewById(R.id.joy_num)).getText().toString();
        barang[3] = ((EditText) findViewById(R.id.head_num)).getText().toString();
        barang[4] = ((EditText) findViewById(R.id.cctv_num)).getText().toString();
        barang[5] = ((EditText) findViewById(R.id.hard_num)).getText().toString();

        num_barang.add(Integer.parseInt(barang[0]));
        num_barang.add(Integer.parseInt(barang[1]));
        num_barang.add(Integer.parseInt(barang[2]));
        num_barang.add(Integer.parseInt(barang[3]));
        num_barang.add(Integer.parseInt(barang[4]));
        num_barang.add(Integer.parseInt(barang[5]));

        Intent intent = new Intent(this, ReceiptActivity.class);
        intent.putExtra("main.barang.num", num_barang);

        startActivity(intent);
    }

}

