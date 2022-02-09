package com.big.o.api.services;

import com.big.o.api.models.Launch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Created by dbudim on 11.12.2021
 */

public interface LaunchService {

    @GET("launches")
    Call<List<Launch>> getAllLaunches();

    @GET("launches")
    Call<List<Launch>> getAllLaunches(@Query("flight_number") Integer flightNumber);

    default Launch makeLaunch(int num){
        return new Launch(num);
    }
}
