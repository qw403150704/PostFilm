package com.example.qw.postfilm.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.qw.postfilm.R;
import com.example.qw.postfilm.activity.SubjectActivity;

import java.util.List;

/**
 * Created by QW on 2017/4/6.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private List<Film> mFilmList;
    private Context context;



    static class ViewHolder extends RecyclerView.ViewHolder{

        View filmView;
        ImageView filmImage;
        TextView filmName;
        RatingBar filmStar;
        TextView filmRating;

        public ViewHolder(View view){
            super(view);
            filmView = view;
            filmImage = (ImageView) view.findViewById(R.id.film_image);
            filmName = (TextView) view.findViewById(R.id.film_name);
            filmStar = (RatingBar) view.findViewById(R.id.rating_stars);
            filmRating = (TextView) view.findViewById(R.id.rating_text);

        }
}

    public FilmAdapter(List<Film> filmList,Context context){

        mFilmList = filmList;
        this.context=context;


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.filmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Film film = mFilmList.get(position);
                Intent intent = new Intent(context,SubjectActivity.class);
                intent.putExtra("filmId",film.getId());
                context.startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film film  = mFilmList.get(position);
//        Glide.with(context).load(film.getImageUrl()).into(holder.filmImage);
        holder.filmImage.setImageBitmap(film.getImage());
        holder.filmName.setText(film.getTitle());

            holder.filmStar.setRating(film.getRating() / 2);
            holder.filmRating.setText(film.getRating().toString());


    }

    @Override
    public int getItemCount() {
        return mFilmList.size();
    }
}
