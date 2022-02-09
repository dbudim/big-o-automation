package com.big.o.api.tools;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dbudim on 12.12.2021
 */

public interface PlanService {

    @GET("get_plan/{pathId}")
    Call<Entry> getPlan(@Path("pathId") int pathId);

}
