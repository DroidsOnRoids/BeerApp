package pl.droidsonroids.beerapp.model;

import java.util.List;

public interface BeerModel {

    List<Beer> getAllBeers();
    Beer getBeerById(final long id);
}
