package com.example.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MovieAdapter  extends ArrayAdapter {

    ArrayList list=new ArrayList();

    public MovieAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class DataHandler{
        ImageView Poster;
        TextView tiltle;
        TextView Rating;
    }

    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    public int getCount(){
        return this.list.size();
    }

    public Object getItem(int postion ){
        return this.list.get(postion);
    }

    public View getView(int postion, View convertView, ViewGroup parent){

        View row;
        row=convertView;

        DataHandler handler=new DataHandler();
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.row_layout,parent,false);
            handler.Poster=row.findViewById(R.id.movie_poster);
            handler.tiltle=row.findViewById(R.id.movie_title);
            handler.Rating=row.findViewById(R.id.movie_rating);

            row.setTag(handler);

        }
        else{
             handler=(DataHandler) row.getTag();
        }

        MovieDataProvider dataProvider;
        dataProvider=(MovieDataProvider)this.getItem(postion);
        handler.Poster.setImageResource(dataProvider.getMovie_poster_resource());
        handler.tiltle.setText(dataProvider.getMovie_title());
        handler.Rating.setText(dataProvider.getMovie_rating());

        return row;

    }
}
