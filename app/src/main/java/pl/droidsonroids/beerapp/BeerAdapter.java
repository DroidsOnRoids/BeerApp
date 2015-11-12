package pl.droidsonroids.beerapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.beerapp.databinding.BeerItemBinding;
import pl.droidsonroids.beerapp.model.Beer;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.BeerViewHolder> {

    private final List<Beer> mBeers;

    public BeerAdapter(final List<Beer> beers) {
        mBeers = new ArrayList<>();
        if (beers != null) {
            mBeers.addAll(beers);
        }
    }

    @Override
    public BeerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final BeerItemBinding binding = BeerItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BeerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final BeerViewHolder holder, final int position) {
        holder.displayBeer(mBeers.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeers.size();
    }

    public static class BeerViewHolder extends RecyclerView.ViewHolder {

        private final BeerItemBinding mBinding;

        public BeerViewHolder(final BeerItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void displayBeer(final Beer beer) {
            mBinding.setBeer(beer);
            mBinding.setHandler(new BeerHandler(beer));
        }

        public static class BeerHandler {

            private final Beer mBeer;

            public BeerHandler(final Beer beer) {
                mBeer = beer;
            }

            public void showBeerDetails(final View view) {
                final Context context = view.getContext();
                context.startActivity(BeerDetailsActivity.getIntent(context, mBeer.getId()));
            }
        }
    }
}