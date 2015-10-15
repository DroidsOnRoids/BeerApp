package pl.droidsonroids.beerapp;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.BeerModel;
import pl.droidsonroids.beerapp.model.Product;
import pl.droidsonroids.beerapp.model.SimpleBeerModel;

public class BeerActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_layout) CollapsingToolbarLayout mToolbarLayout;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.beer_layout) ViewGroup mBeerLayout;
    @Bind(R.id.beer_image) ImageView mBeerImage;
    @Bind(R.id.beer_description) TextView mBeerDescriptionText;
    @Bind(R.id.beer_category) TextView mBeerCategoryText;
    @Bind(R.id.beer_brewer) TextView mBeerBrewerText;
    @Bind(R.id.beer_abv) TextView mBeerAlcoholByVolumeText;
    @Bind(R.id.beer_on_sale) TextView mBeerOnSaleText;
    @Bind(R.id.beer_products) TextView mProductsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);

        ButterKnife.bind(this);

        final BeerModel beerModel = new SimpleBeerModel();
        final Beer beer = beerModel.getBeerById(1L);

        mToolbarLayout.setTitle(beer.getName());

        mBeerOnSaleText.setVisibility(beer.isOnSale() ? View.GONE : View.VISIBLE);
        mBeerDescriptionText.setText(String.format("I'm a %s brewed in %s", beer.getType(), beer.getCountry()));
        mBeerCategoryText.setText(getString(R.string.category, beer.getCategory()));
        mBeerBrewerText.setText(getString(R.string.brewer, beer.getBrewer()));
        mBeerAlcoholByVolumeText.setText(String.format("Alcohol Content (ABV): %.2f%%", beer.getAlcoholByVolume()));

        Picasso.with(this).load(beer.getImageUrl()).into(mBeerImage);

        mProductsText.setText(getString(R.string.products, beer.getProducts().size()));

        for (final Product product : beer.getProducts()) {
            final TextView productText = (TextView) getLayoutInflater().inflate(R.layout.content_product, mBeerLayout, false);
            productText.setText(String.format("%s for $%.2f", product.getSize(), product.getPrice()));
            mBeerLayout.addView(productText);
        }

        setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.fab)
    public void onFloatingActionButtonClicked(final View view) {
        Snackbar.make(view, "FAB clicked!", Snackbar.LENGTH_SHORT).show();
    }
}
