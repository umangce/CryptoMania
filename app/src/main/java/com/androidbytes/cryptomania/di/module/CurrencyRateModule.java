package com.androidbytes.cryptomania.di.module;

import com.androidbytes.cryptomania.common.contract.CurrencyRateContract;
import com.androidbytes.cryptomania.presenter.CurrencyRatePresenter;
import com.androidbytes.cryptomania.repository.CryptoRateRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by umang.kothari on 06/01/18.
 */

@Module(includes = CryptoRepoModule.class)
public class CurrencyRateModule {

    private CurrencyRateContract.View view;

    public CurrencyRateModule(CurrencyRateContract.View view) {
        this.view = view;
    }


    @Provides
    public CurrencyRatePresenter getCurrencyRatePresenter(CryptoRateRepository cryptoRateRepository) {
        return new CurrencyRatePresenter(view, cryptoRateRepository);
    }
}
