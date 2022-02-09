package com.big.o.api.tools;

import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by lolik on 03.02.17.
 */
public class TestrailAuthInterceptor implements Interceptor {


    private static String apikey = "UcZ3pozl6s31Foq6pJlR-RFxLL3NCCpR6LHsZae5W";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .build();

        String token = Credentials.basic("vegos21117@iistoria.com", "1qazXSW@");
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }


}
