package com.big.o.api.tools;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by lolik on 03.02.17.
 */
public class TestrailPathAdapterInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .url(original.url().toString().replace("?", "&").replace("index.php/api/v2/", "index.php?/api/v2/")).build();
        return chain.proceed(request);
    }

}
