package com.androidbytes.cryptomania.di.component;

import com.androidbytes.cryptomania.di.module.CurrencyRateModule;
import com.androidbytes.cryptomania.presenter.CurrencyRatePresenter;

import dagger.Component;

/**
 * Created by umang.kothari on 06/01/18.
 */

@Component(modules = CurrencyRateModule.class)
public interface CurrencyRateComponent {

    CurrencyRatePresenter getCurrencyRatePresenter();
}
