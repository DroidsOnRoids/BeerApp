package pl.droidsonroids.beerapp;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.beerapp.databinding.BeerDetailsActivityBinding;
import pl.droidsonroids.beerapp.databinding.ProductDetailsBinding;
import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.BeerModel;
import pl.droidsonroids.beerapp.model.Product;
import pl.droidsonroids.beerapp.model.rest.RestBeerModel;

public class BeerDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_BEER_ID = "EXTRA_BEER_ID";

    @Bind(R.id.beer_layout) ViewGroup mBeerLayout;

    private BeerDetailsActivityBinding mBinding;

    private BeerModel mBeerModel;

    public static Intent getIntent(final Context context, final long beerId) {
        final Intent intent = new Intent(context, BeerDetailsActivity.class);
        intent.putExtra(EXTRA_BEER_ID, beerId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_beer_details);

        ButterKnife.bind(this);

        mBeerModel = new RestBeerModel();

        loadBeer(getIntent().getLongExtra(EXTRA_BEER_ID, 0L));

        setSupportActionBar(mBinding.toolbar);
    }

    private void loadBeer(final long beerId) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                final Beer beer = mBeerModel.getBeerById(beerId);
                postDisplayBeer(beer);
            }
        });
    }

    private void postDisplayBeer(final Beer beer) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                displayBeer(beer);
            }
        });
    }

    @UiThread
    private void displayBeer(final Beer beer) {
        mBinding.setBeer(beer);
        mBinding.setHandler(new BeerHandler(beer));

        for (final Product product : beer.getProducts()) {
            final ProductDetailsBinding productBinding = ProductDetailsBinding.inflate(getLayoutInflater(), mBeerLayout, true);
            productBinding.setProduct(product);
        }
    }

    public static class BeerHandler {

        private final Beer mBeer;

        public BeerHandler(final Beer beer) {
            mBeer = beer;
        }

        public void addToFavourites(final View view) {
            Snackbar.make(view, mBeer.getName() + " added to favourites.", Snackbar.LENGTH_SHORT).show();
        }
    }
}
