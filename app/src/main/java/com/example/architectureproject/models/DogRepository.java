package com.example.architectureproject.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.architectureproject.services.ApiClient;
import com.example.architectureproject.services.DogService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DogRepository {
    private DogService dogService;

    public MutableLiveData<DogRandomResponse> getDogLiveData() {
        return dogLiveData;
    }

    private MutableLiveData<DogRandomResponse> dogLiveData = new MutableLiveData<>();

    public DogRepository() {
        dogService = ApiClient.getRetrofitInstance().create(DogService.class);
    }

    public LiveData<DogRandomResponse> getRandomDogData() {
        dogService.fetchRandomDog().enqueue(new Callback<DogRandomResponse>() {
            @Override
            public void onResponse(Call<DogRandomResponse> call, Response<DogRandomResponse> response) {
                dogLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DogRandomResponse> call, Throwable t) {
                dogLiveData.setValue(null);
            }
        });

        return dogLiveData;
    }
}
