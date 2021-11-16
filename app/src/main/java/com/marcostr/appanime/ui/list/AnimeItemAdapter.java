package com.marcostr.appanime.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.marcostr.appanime.R;
import com.marcostr.appanime.model.Anime;

import java.util.List;


public class AnimeItemAdapter extends RecyclerView.Adapter<AnimeItemAdapter.AnimeViewHolder> {
    private Context context;
    private List<Anime> animeList;
    private ItemClickListener clickListener;

    public interface ItemClickListener{

        public void onMovieClick( Anime anime);

    }

    public AnimeItemAdapter (Context context, List<Anime> animeList, ItemClickListener clickListener) {
        this.context = context;
        this.animeList = animeList;
        this.clickListener = clickListener;
    }

    public void setMovieList(List<Anime> list) {
        this.animeList = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_anime, parent, false);
        return new AnimeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.textViewAnimeTitle.setText(this.animeList.get(position).getTitle().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onMovieClick(animeList    .get(position));
            }
        });
        Glide.with(context)
                .load(this.animeList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageViewAnime);
    }

    @Override
    public int getItemCount() {
        if(this.animeList != null) {
            return this.animeList.size();
        }
        return 0;
    }


    public class AnimeViewHolder extends RecyclerView.ViewHolder{

        TextView textViewAnimeTitle;
        ImageView imageViewAnime;


        public AnimeViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewAnimeTitle = (TextView)itemView.findViewById(R.id.textViewAnimeTitle);
            imageViewAnime = (ImageView)itemView.findViewById(R.id.imageViewAnime);

        }

    }

}
