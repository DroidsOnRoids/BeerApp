package pl.droidsonroids.beerapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.Collections;

import pl.droidsonroids.beerapp.R;
import pl.droidsonroids.beerapp.databinding.BeerListActivityBinding;
import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.rest.RestBeerModel;
import pl.droidsonroids.beerapp.viewmodel.BeerListViewModel;

public class BeerListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private BeerListViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new BeerListViewModel(new RestBeerModel());

        final BeerListActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_beer_list);
        binding.setViewModel(mViewModel);

        binding.swipeLayout.setColorSchemeResources(R.color.colorAccent);
        binding.swipeLayout.setOnRefreshListener(this);
        binding.swipeLayout.post(new Runnable() {
            @Override
            public void run() {
                mViewModel.onFirstRefresh();
            }
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new BeerAdapter(Collections.<Beer>emptyList()));

        setSupportActionBar(binding.toolbar);
    }

    @Override
    public void onRefresh() {
        mViewModel.onRefresh();
    }
}
