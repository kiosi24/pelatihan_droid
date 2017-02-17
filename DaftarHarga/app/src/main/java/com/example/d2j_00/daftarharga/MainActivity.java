package com.example.d2j_00.daftarharga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tambah(View view) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    public void tampil(View view) {
        Intent intent = new Intent(this, TotalActivity.class);
        startActivity(intent);
    }
}