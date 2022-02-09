package com.big.o.api.tools;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

/**
 * Created by dbudim on 12.12.2021
 */

public interface ResultsService {

    @POST("add_result/{testId}")
    Call<ResponseBody> addResult(@Path("testId") String testId, @Body Result result);

    @POST("add_results/{runId}")
    Call<ResponseBody> addResults(@Path("runId") int runId, @Body Results result);

    @GET("get_tests/{runId}")
    Call<Tests> getTests(@Path("runId") String runId);

}
