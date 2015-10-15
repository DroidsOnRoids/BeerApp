package pl.droidsonroids.beerapp.model;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SimpleBeerModel implements BeerModel {

    private static final String JSON_BEER = "{\n" +
            "  \"name\": \"Becks\",\n" +
            "  \"beer_id\": 2054,\n" +
            "  \"image_url\": \"http://www.thebeerstore.ca/sites/default/files/styles/brand_hero/public/sbs/brand/TBS_Brand_Lockups_BECKS.jpg?itok=hrQZYy1I\",\n" +
            "  \"category\": \"Imported\",\n" +
            "  \"abv\": \"5.0\",\n" +
            "  \"type\": \"Lager\",\n" +
            "  \"brewer\": \"Brauerei Beck & Company\",\n" +
            "  \"country\": \"Germany\",\n" +
            "  \"on_sale\": false\n" +
            "}";

    private static final String JSON_PRODUCTS = "[\n" +
            "  {\n" +
            "    \"product_id\": 2054063,\n" +
            "    \"name\": \"Becks\",\n" +
            "    \"size\": \"1  ×  Can 500 ml\",\n" +
            "    \"price\": \"2.50\",\n" +
            "    \"beer_id\": 2054,\n" +
            "    \"image_url\": \"http://www.thebeerstore.ca/sites/default/files/styles/brand_hero/public/sbs/brand/TBS_Brand_Lockups_BECKS.jpg?itok=hrQZYy1I\",\n" +
            "    \"category\": \"Imported\",\n" +
            "    \"abv\": \"5.0\",\n" +
            "    \"type\": \"Lager\",\n" +
            "    \"brewer\": \"Brauerei Beck & Company\",\n" +
            "    \"country\": \"Germany\",\n" +
            "    \"on_sale\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"product_id\": 2054130,\n" +
            "    \"name\": \"Becks\",\n" +
            "    \"size\": \"24  ×  Can 500 ml\",\n" +
            "    \"price\": \"55.95\",\n" +
            "    \"beer_id\": 2054,\n" +
            "    \"image_url\": \"http://www.thebeerstore.ca/sites/default/files/styles/brand_hero/public/sbs/brand/TBS_Brand_Lockups_BECKS.jpg?itok=hrQZYy1I\",\n" +
            "    \"category\": \"Imported\",\n" +
            "    \"abv\": \"5.0\",\n" +
            "    \"type\": \"Lager\",\n" +
            "    \"brewer\": \"Brauerei Beck & Company\",\n" +
            "    \"country\": \"Germany\",\n" +
            "    \"on_sale\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"product_id\": 2054011,\n" +
            "    \"name\": \"Becks\",\n" +
            "    \"size\": \"6  ×  Bottle 330 ml\",\n" +
            "    \"price\": \"13.25\",\n" +
            "    \"beer_id\": 2054,\n" +
            "    \"image_url\": \"http://www.thebeerstore.ca/sites/default/files/styles/brand_hero/public/sbs/brand/TBS_Brand_Lockups_BECKS.jpg?itok=hrQZYy1I\",\n" +
            "    \"category\": \"Imported\",\n" +
            "    \"abv\": \"5.0\",\n" +
            "    \"type\": \"Lager\",\n" +
            "    \"brewer\": \"Brauerei Beck & Company\",\n" +
            "    \"country\": \"Germany\",\n" +
            "    \"on_sale\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"product_id\": 2054013,\n" +
            "    \"name\": \"Becks\",\n" +
            "    \"size\": \"24  ×  Bottle 330 ml\",\n" +
            "    \"price\": \"45.95\",\n" +
            "    \"beer_id\": 2054,\n" +
            "    \"image_url\": \"http://www.thebeerstore.ca/sites/default/files/styles/brand_hero/public/sbs/brand/TBS_Brand_Lockups_BECKS.jpg?itok=hrQZYy1I\",\n" +
            "    \"category\": \"Imported\",\n" +
            "    \"abv\": \"5.0\",\n" +
            "    \"type\": \"Lager\",\n" +
            "    \"brewer\": \"Brauerei Beck & Company\",\n" +
            "    \"country\": \"Germany\",\n" +
            "    \"on_sale\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"product_id\": 2054012,\n" +
            "    \"name\": \"Becks\",\n" +
            "    \"size\": \"12  ×  Bottle 330 ml\",\n" +
            "    \"price\": \"24.95\",\n" +
            "    \"beer_id\": 2054,\n" +
            "    \"image_url\": \"http://www.thebeerstore.ca/sites/default/files/styles/brand_hero/public/sbs/brand/TBS_Brand_Lockups_BECKS.jpg?itok=hrQZYy1I\",\n" +
            "    \"category\": \"Imported\",\n" +
            "    \"abv\": \"5.0\",\n" +
            "    \"type\": \"Lager\",\n" +
            "    \"brewer\": \"Brauerei Beck & Company\",\n" +
            "    \"country\": \"Germany\",\n" +
            "    \"on_sale\": false\n" +
            "  }\n" +
            "]";

    private final Beer mBeer;

    public SimpleBeerModel() {
        final Gson gson = new Gson();
        mBeer = gson.fromJson(JSON_BEER, Beer.class);
        mBeer.setProducts(Arrays.asList(gson.fromJson(JSON_PRODUCTS, Product[].class)));
    }

    @Override
    public List<Beer> getAllBeers() {
        return Collections.singletonList(mBeer);
    }

    @Override
    public Beer getBeerById(final long id) {
        return mBeer;
    }
}
