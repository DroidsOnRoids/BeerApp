package pl.droidsonroids.beerapp.model.rest;

import java.util.List;

import pl.droidsonroids.beerapp.model.Beer;
import pl.droidsonroids.beerapp.model.Product;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface BeerService {

    @GET("/beers")
    Call<List<Beer>> listBeers();

    @GET("/beers/{id}")
    Call<Beer> getBeer(@Path("id") final long beerId);

    @GET("/beers/{id}/products")
    Call<List<Product>> getProductsForBeer(@Path("id") final long beerId);
}
