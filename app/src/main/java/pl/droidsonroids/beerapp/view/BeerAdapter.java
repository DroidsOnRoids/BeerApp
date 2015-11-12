package pl.droidsonroids.beerapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.beerapp.databinding.BeerItemBinding;
import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.viewmodel.BeerItemViewModel;

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
            if (mBinding.getViewModel() == null) {
                mBinding.setViewModel(new BeerItemViewModel());
            }
            mBinding.getViewModel().getBeer().set(beer);
        }
    }
}