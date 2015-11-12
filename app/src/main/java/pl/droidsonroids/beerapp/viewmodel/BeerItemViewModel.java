package pl.droidsonroids.beerapp.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.view.BeerDetailsActivity;

public class BeerItemViewModel {

    private final ObservableField<Beer> mBeer = new ObservableField<>();

    public ObservableField<Beer> getBeer() {
        return mBeer;
    }

    public void showBeerDetails(final View view) {
        final Context context = view.getContext();
        context.startActivity(BeerDetailsActivity.getIntent(context, mBeer.get().getId()));
    }
}
