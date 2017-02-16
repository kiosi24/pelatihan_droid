package com.example.d2j_00.daftarharga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {


    private String [] jenisStr = {"Honda", "Yamaha", "Suzuki", "Kawasaki", "Ducati"};
    private EditText edtNama, edtUnit, edtKeterangan;
    private Spinner spnJenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        spnJenis = (Spinner) findViewById(R.id.jns);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnJenis.setAdapter(adapter);

        edtNama = (EditText) findViewById(R.id.trans);
        edtUnit = (EditText) findViewById(R.id.jml);
        edtKeterangan = (EditText) findViewById(R.id.ket);
    }


    public void saveTransaksi(View view){
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        String nama = edtNama.getText().toString();
        int jenis = spnJenis.getSelectedItemPosition()+1;
        int jumlah = Integer.parseInt(edtUnit.getText().toString());
        String  keterangan = edtKeterangan.getText().toString();

        dbHelper.insertTransaksi(nama, jenis, jumlah, keterangan);

        Log.d("form.transaksi", nama+" - "+Integer.toString(jenis)+" - "+Integer.toString(jumlah)
                +" - "+keterangan);
        Toast.makeText(this, "Transaksi "+nama+" Berhasil disimpan",Toast.LENGTH_SHORT).show();

        //    startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
