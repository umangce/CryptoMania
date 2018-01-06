package com.androidbytes.cryptomania.repository.network.service;

import com.androidbytes.cryptomania.repository.network.model.CurrencyPriceVO;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by umang.kothari on 06/01/18.
 */

public interface ICryptoManiaWebService {

    @GET("api/ticker")
    Single<CurrencyPriceVO> getPricesOfCryptoCurrencies();
}
