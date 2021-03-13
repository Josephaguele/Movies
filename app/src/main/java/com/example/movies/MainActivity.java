package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MoviesListFragment mMoviesListFragment;
    private MoviesRViewAdapter adapter;
    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";

    ArrayList<Movies> movies;

    // Here we update the onCreate method to use the Fragment Manager to add the movies List
    // Fragment to the frame Layout we defined. If an activity is recreated due to a device
    // configuration change, any fragments added using the Fragment Manager will automatically be
    // re-added. As a result, we only add a new fragment if this is not a configuration-change restart;
    // otherwise, we can find it using its tag:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_main);

        FragmentManager fm = getSupportFragmentManager();
        // Android will automatically re-add any Fragments that have previously been added
        // after a configuration change, so only add it if this isn't an automatic restart
        if (savedInstanceState == null)
        {
            FragmentTransaction ft  = fm.beginTransaction();
            mMoviesListFragment = new MoviesListFragment();
            ft.add(R.id.main_activity_frame,  mMoviesListFragment, TAG_LIST_FRAGMENT);
            ft.commitNow();
        } else
        {
            mMoviesListFragment =(MoviesListFragment) fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }

        List<Movies> dd = new ArrayList<>(0);
        dd.add(new Movies("Bayo","3","5","fyy","8","af","1"));
        dd.add(new Movies("Kunle","3","5","fyy","8","af","1"));
        dd.add(new Movies("Dolapo","3","5","fyy","8","af","1"));
        dd.add(new Movies("Titi","3","5","fyy","8","af","1"));

        mMoviesListFragment.setMovies(dd);
    }
}
