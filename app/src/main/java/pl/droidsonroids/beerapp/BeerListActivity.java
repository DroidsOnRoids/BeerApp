package pl.droidsonroids.beerapp;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.Collections;
import java.util.List;

import pl.droidsonroids.beerapp.databinding.BeerListActivityBinding;
import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.BeerModel;
import pl.droidsonroids.beerapp.model.rest.RestBeerModel;

public class BeerListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private BeerListActivityBinding mBinding;

    private BeerModel mBeerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_beer_list);

        mBeerModel = new RestBeerModel();

        mBinding.swipeLayout.setColorSchemeResources(R.color.colorAccent);
        mBinding.swipeLayout.setOnRefreshListener(this);
        mBinding.swipeLayout.post(new Runnable() {
            @Override
            public void run() {
                mBinding.swipeLayout.setRefreshing(true);
                loadBeers();
            }
        });

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(new BeerAdapter(Collections.<Beer>emptyList()));

        setSupportActionBar(mBinding.toolbar);
    }

    @Override
    public void onRefresh() {
        loadBeers();
    }

    private void loadBeers() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                final List<Beer> beers = mBeerModel.getAllBeers();
                postDisplayBeers(beers);
            }
        });
    }

    private void postDisplayBeers(final List<Beer> beers) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                displayBeers(beers);
            }
        });
    }

    @UiThread
    private void displayBeers(final List<Beer> beers) {
        mBinding.setBeers(beers);
        mBinding.swipeLayout.setRefreshing(false);
    }
}
