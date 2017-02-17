package com.example.d2j_00.daftarharga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class InputActivity extends AppCompatActivity {


    private String [] jenisStr = {"Honda", "Yamaha", "Suzuki", "Kawasaki", "Ducati"};
    private EditText edtNama, edtUnit,edtHarga, edtTotal;
    private Spinner spnJenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        spnJenis = (Spinner) findViewById(R.id.jns);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnJenis.setAdapter(adapter);

        edtNama = (EditText) findViewById(R.id.nama);
        edtHarga = (EditText) findViewById(R.id.harga);
        edtUnit = (EditText) findViewById(R.id.unit);
        edtTotal = (EditText) findViewById(R.id.tot);
    }

    public void hitung_total () {

        spnJenis = (Spinner) findViewById(R.id.jns);
        edtUnit = (EditText) findViewById(R.id.unit);
        edtTotal = (EditText) findViewById(R.id.tot);

        int result = 0;
        double jumlahh;
        jumlahh=Double.parseDouble(edtUnit.getText().toString());

        if(spnJenis.getSelectedItem()=="Honda")
        {
            result+=+jumlahh*1500000;
        }
        else if(spnJenis.getSelectedItem()=="Yamaha")
        {
            result+=+jumlahh*2000000;
        }
        else if(spnJenis.getSelectedItem()=="Suzuki")
        {
            result+=+jumlahh*2500000;
        }
        else if(spnJenis.getSelectedItem()=="Kawasaki")
        {
            result+=+jumlahh*300000;
        }
        else
            result+=+jumlahh*5000000;

        EditText total= (EditText) findViewById(R.id.tot);
        total.setText(Integer.toString(result));
    }
    public void view_harga() {
        spnJenis = (Spinner) findViewById(R.id.jns);

        int hargaa;
        if (spnJenis.getSelectedItem() == "Honda") {
            hargaa = 1400000;

        } else if (spnJenis.getSelectedItem() == "Yamaha") {
            hargaa = 1300000;

        } else if (spnJenis.getSelectedItem() == "Suzuki") {
            hargaa = 2100000;

        } else if (spnJenis.getSelectedItem() == "Kawasaki") {
            hargaa = 2250000;

        }
        else
            hargaa=5000000;

        EditText hargax= (EditText) findViewById(R.id.harga);
        hargax.setText(Integer.toString(hargaa));
    }

    public void jenis(View view)
    {
        view_harga();
    }

    public void tampilTotal(View view)
    {
        hitung_total();
    }




    public void saveTransaksi(View view){
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        String nama = edtNama.getText().toString();
        int jenis = spnJenis.getSelectedItemPosition()+1;
        int harga = Integer.parseInt(edtHarga.getText().toString());
        int unit = Integer.parseInt(edtUnit.getText().toString());
        int  total = Integer.parseInt(edtTotal.getText().toString());

        dbHelper.insertTransaksi(nama, jenis, harga, unit, total);

        Log.d("form.transaksi", nama+" - "+Integer.toString(jenis)+" - "+" - "+Integer.toString(harga)+" - "+Integer.toString(unit)
                +" - "+Integer.toString(total));
        Toast.makeText(this, "Transaksi "+nama+" Berhasil disimpan",Toast.LENGTH_SHORT).show();

        //    startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
