package pl.droidsonroids.beerapp.model.rest;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.BeerModel;
import pl.droidsonroids.beerapp.model.Product;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class RestBeerModel implements BeerModel {

    private final BeerService mBeerService;

    public RestBeerModel() {
        final Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://ontariobeerapi.ca")
                .build();

        mBeerService = retrofit.create(BeerService.class);
    }

    @Override
    public List<Beer> getAllBeers() {
        try {
            final Response<List<Beer>> response = mBeerService.listBeers().execute();
            if (response.isSuccess()) {
                return response.body();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Beer getBeerById(final long id) {
        try {
            final Response<Beer> response = mBeerService.getBeer(id).execute();
            if (response.isSuccess()) {
                final Response<List<Product>> productsResponse = mBeerService.getProductsForBeer(id).execute();
                response.body().setProducts(productsResponse.isSuccess() ? productsResponse.body() : Collections.<Product>emptyList());
                return response.body();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
