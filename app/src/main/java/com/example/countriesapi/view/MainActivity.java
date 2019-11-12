package com.example.countriesapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.countriesapi.OnActionPerformedListener;
import com.example.countriesapi.R;
import com.example.countriesapi.model.entity.Country;
import com.example.countriesapi.presenter.BasePresenter;
import com.example.countriesapi.presenter.CountryContract;
import com.example.countriesapi.presenter.CountryPresenterImpl;
import com.example.countriesapi.view.adapter.RVAdapter;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import static com.example.countriesapi.view.adapter.RVAdapter.COUNTRY_NAME;

public class MainActivity
        extends AppCompatActivity
        implements OnActionPerformedListener, CountryContract.View {

    public static final String BY_COUNTRY_NAME = "by Country Name";
    public static final String BY_LANGUAGE = "by Language";
    public static final String BY_REGION = "by Region";
    public static final String BY_CAPITAL = "by Capital";
    private RecyclerView recyclerView;
    private RVAdapter adapter;

    private SearchView searchView;
    private Spinner spinner;
    private ArrayAdapter spinnerAdapter;
    private MaterialButton btnSearch;

    private CountryContract.Presenter presenter;

    private String choice;
    private String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupSearch();
        setupSpinner();
    }

    private void setupSearch() {

        searchView = findViewById(R.id.search);
        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query = searchView.getQuery().toString();
                searchView.setQuery("", false);
                doSearch(query);
            }
        });
    }

    private void setupSpinner() {
        spinner = findViewById(R.id.spinner);
        spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.search_params, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                choice = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void doSearch(String query) {
        switch (choice) {

            case BY_COUNTRY_NAME:
                presenter.actionName(query);
                break;

            case BY_LANGUAGE:
                presenter.actionLang(query);
                break;

            case BY_REGION:
                presenter.actionRegion(query);
                break;

            case BY_CAPITAL:
                presenter.actionCapital(query);
                break;

        }
    }

    private void setupAdapter(List<Country> list) {
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new RVAdapter(list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onActionPerformed(Bundle bundle) {

        String name = bundle.getString(COUNTRY_NAME);
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(COUNTRY_NAME, name);
        startActivity(intent);
    }

    @Override
    public void showAll(List<Country> list) {
        setupAdapter(list);
    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (CountryContract.Presenter) presenter;
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter = new CountryPresenterImpl(this);
        presenter.actionAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
