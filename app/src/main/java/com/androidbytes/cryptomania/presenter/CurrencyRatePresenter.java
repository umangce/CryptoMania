package com.androidbytes.cryptomania.presenter;

import com.androidbytes.cryptomania.common.contract.CurrencyRateContract;
import com.androidbytes.cryptomania.repository.CryptoRateRepository;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by umang.kothari on 06/01/18.
 */

public class CurrencyRatePresenter implements CurrencyRateContract.Presenter {

    private CryptoRateRepository cryptoRateRepository;
    private CurrencyRateContract.View view;
    private Disposable disposable;

    public CurrencyRatePresenter(CurrencyRateContract.View view, CryptoRateRepository cryptoRateRepository) {
        this.cryptoRateRepository = cryptoRateRepository;
        this.view = view;
    }

    @Override
    public void fetchCurrencyRates() {

        disposable = Flowable.interval(60, TimeUnit.SECONDS)
                .flatMap(it -> cryptoRateRepository.getPricesOfCryptoCurrencies().toFlowable())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(currencyPriceVO -> view.fetchCurrencyRatesSucceeded(currencyPriceVO.getPrices()),
                        error -> view.fetchCurrencyRatesFailed());
    }

    public void stopFetchingCurrencyRates() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
