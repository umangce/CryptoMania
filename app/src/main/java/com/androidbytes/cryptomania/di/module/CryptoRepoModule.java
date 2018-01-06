package com.androidbytes.cryptomania.di.module;

import com.androidbytes.cryptomania.repository.CryptoRateRepository;
import com.androidbytes.cryptomania.repository.network.service.ICryptoManiaWebService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by umang.kothari on 06/01/18.
 */

@Module(includes = WebServiceModule.class)
public class CryptoRepoModule {

    @Provides
    public CryptoRateRepository getCryptoRateRepository(ICryptoManiaWebService webService) {
        return new CryptoRateRepository(webService);
    }
}