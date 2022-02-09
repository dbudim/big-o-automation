package com.big.o.api.services;

import com.big.o.api.models.Ship;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by dbudim on 12.12.2021
 */

public interface ShipsService {

    @GET("ships")
    Call<List<Ship>> getShips();

    @GET("ships/{ship_id}")
    Call<Ship> getShip(@Path("ship_id") String shipId);
}
