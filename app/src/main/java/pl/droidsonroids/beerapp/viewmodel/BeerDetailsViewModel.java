package pl.droidsonroids.beerapp.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import pl.droidsonroids.beerapp.databinding.ProductDetailsBinding;
import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.BeerModel;
import pl.droidsonroids.beerapp.model.Product;

public class BeerDetailsViewModel {

    private final BeerModel mBeerModel;

    private final ObservableField<Beer> mBeer = new ObservableField<>();

    @BindingAdapter({"bind:products"})
    public static void displayProducts(final LinearLayout linearLayout, final List<Product> products) {
        if (products != null) {
            for (final Product product : products) {
                final ProductDetailsBinding productBinding = ProductDetailsBinding.inflate(LayoutInflater.from(linearLayout.getContext()), linearLayout, true);
                productBinding.setProduct(product);
            }
        }
    }

    public BeerDetailsViewModel(final BeerModel beerModel, final long beerId) {
        mBeerModel = beerModel;
        loadBeer(beerId);
    }

    public ObservableField<Beer> getBeer() {
        return mBeer;
    }

    private void loadBeer(final long beerId) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                mBeer.set(mBeerModel.getBeerById(beerId));
            }
        });
    }

    public void addToFavourites(final View view) {
        Snackbar.make(view, mBeer.get().getName() + " added to favourites.", Snackbar.LENGTH_SHORT).show();
    }
}
