package com.androidbytes.cryptomania.di.module;

import com.androidbytes.cryptomania.common.constants.Constants;
import com.androidbytes.cryptomania.repository.network.service.ICryptoManiaWebService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by umang.kothari on 06/01/18.
 */

@Module
public class WebServiceModule {

    @Provides
    public ICryptoManiaWebService getWebServiceInstance(Retrofit retrofit) {
        return retrofit.create(ICryptoManiaWebService.class);
    }

    @Provides
    public Retrofit getRetrofitInstance(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public OkHttpClient getOkHttpClientInstance() {
        return new OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build();
    }
}
