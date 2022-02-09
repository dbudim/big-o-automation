package com.big.o.api.tools;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by dbudim on 12.12.2021
 */

public class TestrailRestClient {

    public static final String BASE_URL = "https://demoguild.testrail.io/index.php/api/v2/";
    public static final String PROJECT_ID = "1";

    public ResultsService results;
    public PlanService planService;
    public CaseService caseService;

    public TestrailRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TestrailAuthInterceptor())
                .addInterceptor(new TestrailPathAdapterInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        results = retrofit.create(ResultsService.class);
        planService = retrofit.create(PlanService.class);
        caseService = retrofit.create(CaseService.class);
    }


}
