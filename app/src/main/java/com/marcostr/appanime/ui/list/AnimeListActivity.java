package com.marcostr.appanime.ui.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.marcostr.appanime.R;
import com.marcostr.appanime.model.Anime;

import java.util.List;


public class AnimeListActivity extends AppCompatActivity implements AnimeItemAdapter.ItemClickListener {

    private List<Anime> movieModelList;
    private AnimeItemAdapter adapter;
    private AnimeListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewAnime);

        adapter = new AnimeItemAdapter(this, movieModelList, this);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(AnimeListViewModel.class);
        viewModel.getAnimeList().observe(this, new Observer<List<Anime>>() {
            @Override
            public void onChanged(List<Anime> movieModels) {

                    movieModelList = movieModels;
                    adapter.setMovieList(movieModels);
            }
        });
        viewModel.makeApiCall();


    }

    @Override
    public void onMovieClick(Anime anime) {

        Toast.makeText(this, "Clicked Movie Name is : " + anime.getTitle(), Toast.LENGTH_SHORT).show();



    }
}