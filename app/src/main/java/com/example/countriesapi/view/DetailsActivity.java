package com.example.countriesapi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.countriesapi.R;
import com.example.countriesapi.model.entity.Country;
import com.example.countriesapi.presenter.BasePresenter;
import com.example.countriesapi.presenter.CountryContract;
import com.example.countriesapi.presenter.DetailsContract;
import com.example.countriesapi.presenter.DetailsPresenterImpl;

import java.util.List;

import static com.example.countriesapi.view.adapter.RVAdapter.COUNTRY_NAME;

public class DetailsActivity
        extends AppCompatActivity
        implements DetailsContract.View {

    private DetailsContract.Presenter presenter;
    private Toolbar toolbar;

    private TextView name,
            alpha3,
            capital,
            region,
            subregion,
            population,
            timezone,
            borders,
            currencies,
            languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        presenter = new DetailsPresenterImpl(this);

        if (getIntent() != null) {
            presenter.actionName(getIntent().getStringExtra(COUNTRY_NAME));
        }

        setupViews();
        setupToolBar();

    }


    private void setupViews() {
        name = findViewById(R.id.c_name);
        alpha3 = findViewById(R.id.c_alpha3);
        capital = findViewById(R.id.c_capital);
        region = findViewById(R.id.c_region);
        subregion = findViewById(R.id.c_subregion);
        population = findViewById(R.id.c_population);
        timezone = findViewById(R.id.c_timezone);
        borders = findViewById(R.id.c_borders);
        currencies = findViewById(R.id.c_currencies);
        languages = findViewById(R.id.c_languages);
    }


    private void setupToolBar() {
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showSelected(Country c) {

        name.setText(c.getName());
        alpha3.setText(c.getAlpha3Code());
        capital.setText(c.getCapital());
        region.setText(c.getRegion());
        subregion.setText(c.getSubregion());
        population.setText(c.getPopulation() + "");

        StringBuilder sb = new StringBuilder();
        for(String s : c.getTimezones()) {
            sb.append(s).append(" ");
        }

        timezone.setText(sb);

        sb = new StringBuilder();
        for(String s : c.getBorders()) {
            sb.append(s).append(" ");
        }

        borders.setText(sb);

        sb = new StringBuilder();
        for(String s : c.getCurrencies()) {
            sb.append(s).append(" ");
        }

        currencies.setText(sb);

        sb = new StringBuilder();
        for(String s : c.getLanguages()) {
            sb.append(s).append(" ");
        }

        languages.setText(sb);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (DetailsContract.Presenter) presenter;
    }

    @Override
    public void showToast(String message) {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
