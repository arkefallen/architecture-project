package com.example.architectureproject.services;

import com.example.architectureproject.models.DogRandomResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogService {
    @GET ("breeds/image/random")
    Call<DogRandomResponse> fetchRandomDog();
}
