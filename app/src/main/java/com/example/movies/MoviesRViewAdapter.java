package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class MoviesRViewAdapter extends RecyclerView.Adapter<MoviesRViewAdapter.ViewHolder>
{
    // store a member variable for the movie
    private final List<Movies> mMovies;

    // Pass in the movieArray into the constructor
    public MoviesRViewAdapter(List<Movies> movies)
    {
        mMovies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // inflate the custom layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item_activity, parent,false);

        // return a new Holder instance.
        return new ViewHolder(view);
    }

    // Involves populating data into the item through holder.
    @Override
    public void onBindViewHolder(MoviesRViewAdapter.ViewHolder holder, int position)
    {
         Movies movies = mMovies.get(position);
        // Set item views based on your views and data model
        TextView textView = holder.movieTitleView;
        textView.setText(movies.getMovieTitle());



    }


    @Override
    public int getItemCount()
    {
        return mMovies.size();
    }


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public  final ImageView thumbImageView;
        public  final TextView movieTitleView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View view)
        {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(view);

            thumbImageView = view.findViewById(R.id.thumbImage);
            movieTitleView = view.findViewById(R.id.movieTitle);
        }

        @Override
        public String toString() {
            return super.toString()+" ;"+ movieTitleView.getText();
        }
    }
}
