package com.androidbytes.cryptomania.common.contract;

import com.androidbytes.cryptomania.repository.network.model.Prices;

/**
 * Created by umang.kothari on 06/01/18.
 */

public interface CurrencyRateContract {

    interface View {
        void fetchCurrencyRatesSucceeded(Prices prices);

        void fetchCurrencyRatesFailed();
    }

    interface Presenter {
        void fetchCurrencyRates();
    }
}
