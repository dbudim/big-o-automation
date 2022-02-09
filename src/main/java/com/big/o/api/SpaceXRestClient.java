package com.big.o.api;

import com.big.o.api.services.LaunchService;
import com.big.o.api.services.ShipsService;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Duration;

/**
 * Created by dbudim on 11.12.2021
 */

public class SpaceXRestClient {

    public LaunchService launchService;
    public ShipsService shipsService;

    private static final String BASE_URL = "https://api.spacexdata.com/v3/";

    public SpaceXRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(Duration.ofSeconds(30))
                .writeTimeout(Duration.ofSeconds(30))
                .connectTimeout(Duration.ofSeconds(30))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        launchService = retrofit.create(LaunchService.class);
        shipsService = retrofit.create(ShipsService.class);
    }
}
