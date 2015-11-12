package pl.droidsonroids.beerapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Beer {

    private List<Product> mProducts;

    @SerializedName("name") private String mName;
    @SerializedName("image_url") private String mImageUrl;
    @SerializedName("category") private String mCategory;
    @SerializedName("type") private String mType;
    @SerializedName("brewer") private String mBrewer;
    @SerializedName("country") private String mCountry;
    @SerializedName("beer_id") private long mId;
    @SerializedName("abv") private float mAlcoholByVolume;
    @SerializedName("on_sale") private boolean mOnSale;

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(final List<Product> products) {
        mProducts = products;
    }

    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(final String category) {
        mCategory = category;
    }

    public String getType() {
        return mType;
    }

    public void setType(final String type) {
        mType = type;
    }

    public String getBrewer() {
        return mBrewer;
    }

    public void setBrewer(final String brewer) {
        mBrewer = brewer;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(final String country) {
        mCountry = country;
    }

    public long getId() {
        return mId;
    }

    public void setId(final long id) {
        mId = id;
    }

    public float getAlcoholByVolume() {
        return mAlcoholByVolume;
    }

    public void setAlcoholByVolume(final float alcoholByVolume) {
        mAlcoholByVolume = alcoholByVolume;
    }

    public boolean isOnSale() {
        return mOnSale;
    }

    public void setOnSale(final boolean onSale) {
        mOnSale = onSale;
    }
}
