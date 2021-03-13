package com.example.movies;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// We create a new MoviesListFragment class that extends Fragment and stores an array of movies.
public class MoviesListFragment extends Fragment
{
    private ArrayList<Movies> mMovies = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private MoviesRViewAdapter moviesRViewAdapter = new MoviesRViewAdapter(mMovies);

    public MoviesListFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override // This inflates the layout
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_movies_list,container,false);

        mRecyclerView = view.findViewById(R.id.rec_list);
        return view;
    }

    // This assigns the recyclerviewAdapter to the recycler view

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        // Set the Recycler View Adapter
        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(moviesRViewAdapter);
    }

    // This takes a list of Movies, checks for duplicates and then adds each new Movie to teh
    // ArrayList. It hsould also notify the Recycler View Adapter that a new item has been inserted.
    public void setMovies(List<Movies> mvoies)
    {
        for ( Movies movie: mvoies)
        {
            if (!mMovies.contains(movie))
            {
                mMovies.add(movie);
                moviesRViewAdapter.notifyItemInserted(mMovies.indexOf(movie));
            }
        }
    }
}
