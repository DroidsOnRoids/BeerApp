package pl.droidsonroids.beerapp.viewmodel;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.BeerModel;
import pl.droidsonroids.beerapp.view.BeerAdapter;

public class BeerListViewModel {

    private final BeerModel mBeerModel;

    private final ObservableList<Beer> mBeers = new ObservableArrayList<>();
    private final ObservableInt mEmptyViewVisibility = new ObservableInt(View.GONE);
    private final ObservableBoolean mSwipeRefreshLayoutRefreshing = new ObservableBoolean();

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(final ImageView imageView, final String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter({"bind:items"})
    public static void loadItems(final RecyclerView recyclerView, final List<Beer> beers) {
        recyclerView.setAdapter(new BeerAdapter(beers));
    }

    @BindingAdapter({"bind:refreshing"})
    public static void setRefreshing(final SwipeRefreshLayout swipeRefreshLayout, final boolean refreshing) {
        swipeRefreshLayout.setRefreshing(refreshing);
    }

    public BeerListViewModel(final BeerModel beerModel) {
        mBeerModel = beerModel;
    }

    public ObservableBoolean getSwipeRefreshLayoutRefreshing() {
        return mSwipeRefreshLayoutRefreshing;
    }

    public ObservableInt getEmptyViewVisibility() {
        return mEmptyViewVisibility;
    }

    public ObservableList<Beer> getBeers() {
        return mBeers;
    }

    public void onFirstRefresh() {
        mSwipeRefreshLayoutRefreshing.set(true);
        loadBeers();
    }

    public void onRefresh() {
        loadBeers();
    }

    private void loadBeers() {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                final List<Beer> beers = mBeerModel.getAllBeers();

                mSwipeRefreshLayoutRefreshing.set(false);
                mSwipeRefreshLayoutRefreshing.notifyChange();

                if (beers.isEmpty()) {
                    mBeers.clear();
                    mEmptyViewVisibility.set(View.VISIBLE);
                } else {
                    mEmptyViewVisibility.set(View.GONE);
                    mBeers.addAll(beers);
                }
            }
        });
    }
}
