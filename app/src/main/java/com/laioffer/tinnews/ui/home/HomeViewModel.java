package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.network.NewsApi;
import com.laioffer.tinnews.repository.NewsRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {


    private final NewsRepository repository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>();

    public HomeViewModel(NewsRepository repository) {
        this.repository = repository;
    }

    public void setCountryInput(String county){
        countryInput.setValue(county);
    }

    public LiveData<NewsResponse> getTopHeadlines(){
        return Transformations.switchMap(countryInput,repository::getTopHeadlines);
    }



}
