package com.example.d2j_00.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by D2J-00 on 10/02/2017.
 */
public class TambahActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        Spinner spinner = (Spinner) findViewById(R.id.pilihrating);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pilrating, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void addFilm(View view){
        String title = ((EditText)findViewById(R.id.inpjudul)).getText().toString();
        int year = Integer.parseInt(((EditText)findViewById(R.id.inptahun)).getText().toString());
        double rating = Double.parseDouble(((Spinner)findViewById(R.id.pilihrating)).getSelectedItem().toString());

        String description = ((EditText)findViewById(R.id.inpdeskripsi)).getText().toString();

        Movie movie = new Movie(title, description, rating, year);

        Intent intent = new Intent();
        intent.putExtra("filmlist.result", movie);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
    }
