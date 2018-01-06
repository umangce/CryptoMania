package com.androidbytes.cryptomania.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androidbytes.cryptomania.R;
import com.androidbytes.cryptomania.common.contract.CurrencyRateContract;
import com.androidbytes.cryptomania.di.component.CurrencyRateComponent;
import com.androidbytes.cryptomania.di.component.DaggerCurrencyRateComponent;
import com.androidbytes.cryptomania.di.module.CurrencyRateModule;
import com.androidbytes.cryptomania.presenter.CurrencyRatePresenter;
import com.androidbytes.cryptomania.repository.network.model.Prices;

import javax.inject.Inject;

public class CurrencyRateActivity extends AppCompatActivity implements CurrencyRateContract.View {

    private final String TAG = "CurrencyRateActivity";

    private CurrencyRatePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_rate);

        CurrencyRateComponent component = DaggerCurrencyRateComponent
                .builder()
                .currencyRateModule(new CurrencyRateModule(this))
                .build();

        presenter = component.getCurrencyRatePresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.fetchCurrencyRates();
    }

    @Override
    public void fetchCurrencyRatesSucceeded(Prices prices) {

        String currencyRates = "Bitcoin: " + prices.getBTC() + "\n"
                + "Ripple: " + prices.getXRP() + "\n"
                + "Litecoin: " + prices.getLTC() + "\n"
                + "Ethereum: " + prices.getETH() + "\n"
                + "Bitcoin Cash: " + prices.getBCH() + "\n"
                + "Golem: " + prices.getGNT() + "\n"
                + "OmiseGO: " + prices.getOMG();
        Log.d(TAG, currencyRates);
    }

    @Override
    public void fetchCurrencyRatesFailed() {

    }


    @Override
    protected void onStop() {
        super.onStop();

        presenter.stopFetchingCurrencyRates();
    }
}
