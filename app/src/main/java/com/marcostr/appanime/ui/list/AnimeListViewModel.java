package com.marcostr.appanime.ui.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.marcostr.appanime.model.Anime;
import com.marcostr.appanime.network.RetrofitInstance;
import com.marcostr.appanime.network.service.AnimeServices;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AnimeListViewModel extends ViewModel {

    private Disposable disposable;
    private MutableLiveData <List<Anime>> _animeList;
    private LiveData<List<Anime>> animeList;

    public AnimeListViewModel() {

        this._animeList = new MutableLiveData<>();
        this.animeList = _animeList;

    }

    public LiveData<List<Anime>> getAnimeList(){
        return animeList;
    }

    void makeApiCall(){

        AnimeServices apiService = RetrofitInstance.getRetrofitClient().create(AnimeServices.class);
        disposable = apiService.getAnimeList ()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    _animeList.postValue(response.parseAnimeList());
                });


    }

}
