package com.example.listviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    int[] movie_poster_res={R.drawable.f1,R.drawable.f2,R.drawable.f3,
                            R.drawable.f4,R.drawable.f5,R.drawable.f6,
                            R.drawable.f7};

    String[] movie_titles;
    String[] movie_ratings;
    MovieAdapter movieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        movie_ratings=getResources().getStringArray(R.array.movies_ratings);
        movie_titles=getResources().getStringArray(R.array.movie_titles);

        int i=0;
        movieAdapter=new MovieAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(movieAdapter);
        for(String titles:movie_titles){

            MovieDataProvider dataProvider=new MovieDataProvider(
                                           movie_poster_res[i],
                                           titles,
                                           movie_ratings[i]);
            movieAdapter.add(dataProvider);

            i++;



        }



    }
}
