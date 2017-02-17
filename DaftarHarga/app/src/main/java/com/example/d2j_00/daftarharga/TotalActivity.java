package com.example.d2j_00.daftarharga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class TotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final ListView listTransaksi = (ListView) findViewById(R.id.list_trasaksi);
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        final List<Transaksi> listTrans = dbHelper.getTransaksi();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTrans);
        listTransaksi.setAdapter(adapter);

        int total = 0;
        for (int i = 0;i<listTrans.size();i++) {
            total += listTrans.get(i).total;
        }

        TextView txtTotal = (TextView) findViewById(R.id.total);
        txtTotal.setText("Total Penjualan : "+Integer.toString(total));


        listTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transaksi transaksi = listTrans.get(position);
                Intent intent = new Intent(parent.getContext(), DetailActivity.class);
                intent.putExtra("transaksi.detail", transaksi);
                startActivity(intent);
            }
        });
    }
}
