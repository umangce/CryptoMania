package com.androidbytes.cryptomania.repository;

import com.androidbytes.cryptomania.repository.network.model.CurrencyPriceVO;
import com.androidbytes.cryptomania.repository.network.service.ICryptoManiaWebService;

import io.reactivex.Single;

/**
 * Created by umang.kothari on 06/01/18.
 */

public class CryptoRateRepository {

    private ICryptoManiaWebService webService;

    public CryptoRateRepository(ICryptoManiaWebService webService) {
        this.webService = webService;
    }

    public Single<CurrencyPriceVO> getPricesOfCryptoCurrencies() {
        return webService.getPricesOfCryptoCurrencies();
    }
}
