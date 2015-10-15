package pl.droidsonroids.beerapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.beerapp.databinding.BeerActivityBinding;
import pl.droidsonroids.beerapp.databinding.ContentProductBinding;
import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.BeerModel;
import pl.droidsonroids.beerapp.model.Product;
import pl.droidsonroids.beerapp.model.SimpleBeerModel;

public class BeerActivity extends AppCompatActivity {

    @Bind(R.id.beer_layout) ViewGroup mBeerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final BeerActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_beer);

        ButterKnife.bind(this);

        final BeerModel beerModel = new SimpleBeerModel();
        final Beer beer = beerModel.getBeerById(1L);

        binding.setBeer(beer);
        binding.setHandler(this);

        for (final Product product : beer.getProducts()) {
            final ContentProductBinding productBinding = ContentProductBinding.inflate(getLayoutInflater(), mBeerLayout, true);
            productBinding.setProduct(product);
        }

        setSupportActionBar(binding.toolbar);
    }

    public void onFloatingActionButtonClicked(final View view) {
        Snackbar.make(view, "FAB clicked!", Snackbar.LENGTH_SHORT).show();
    }
}
