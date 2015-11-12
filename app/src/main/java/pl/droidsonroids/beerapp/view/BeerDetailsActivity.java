package pl.droidsonroids.beerapp.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.droidsonroids.beerapp.R;
import pl.droidsonroids.beerapp.databinding.BeerDetailsActivityBinding;
import pl.droidsonroids.beerapp.model.rest.RestBeerModel;
import pl.droidsonroids.beerapp.viewmodel.BeerDetailsViewModel;

public class BeerDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_BEER_ID = "EXTRA_BEER_ID";

    public static Intent getIntent(final Context context, final long beerId) {
        final Intent intent = new Intent(context, BeerDetailsActivity.class);
        intent.putExtra(EXTRA_BEER_ID, beerId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final BeerDetailsViewModel viewModel = new BeerDetailsViewModel(new RestBeerModel(), getIntent().getLongExtra(EXTRA_BEER_ID, 0L));

        final BeerDetailsActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_beer_details);
        binding.setViewModel(viewModel);

        setSupportActionBar(binding.toolbar);
    }
}
