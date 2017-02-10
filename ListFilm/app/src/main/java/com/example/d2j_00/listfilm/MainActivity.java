package com.example.d2j_00.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String [] filmTitles = {"The Thor","Harry Potter","Ted",
                                    "Hunger Games","Divergent",
                                    "X-Men Apocalypse","Resident Evil"};

    private ArrayList<Movie> movies = new ArrayList<>();

    ArrayAdapter<Movie> adapter;
    ListView listView;

    private void initMovies(){
        movies.add(new Movie("The Thor", "Film tentang superhero Thor yang turun ke bumi", 7.5, 2009));
        movies.add(new Movie("Harry Potter","Film tentang Penyihir", 8, 2000));
        movies.add(new Movie("Ted", "Film tentang boneka yang hidup", 9, 2010));
        movies.add(new Movie("Hunger Games", "Film tentang seorang wanita yang masuk kedalam permainan pembunuhan", 10, 2015));
        movies.add(new Movie("X-Men Apocalypse", "Film tentang mutant", 9, 2015));
        movies.add(new Movie("Resident Evil", "Film tentang zombie", 8, 2016));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMovies();
        ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        ListView listView = (ListView) findViewById(R.id.listFilm);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie selectedMovie = movies.get(position);
                Intent intent = new Intent(getBaseContext(),DetailActivity.class);
                intent.putExtra("ardian.listfilm", selectedMovie);
                startActivity(intent);
            }
        });
    }

    public void ok (View view){
        Intent intent = new Intent(this,TambahActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                Movie newMovie = (Movie) data.getSerializableExtra("filmlist.result");
                movies.add((newMovie));
                adapter.notifyDataSetChanged();
            }
        }
    }
}
