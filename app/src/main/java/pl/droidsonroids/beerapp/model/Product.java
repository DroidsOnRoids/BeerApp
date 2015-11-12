package pl.droidsonroids.beerapp.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import pl.droidsonroids.beerapp.BR;

public class Product extends BaseObservable {

    @SerializedName("name") private String mName;
    @SerializedName("size") private String mSize;
    @SerializedName("image_url") private String mImageUrl;
    @SerializedName("category") private String mCategory;
    @SerializedName("type") private String mType;
    @SerializedName("brewer") private String mBrewer;
    @SerializedName("country") private String mCountry;
    @SerializedName("product_id") private long mId;
    @SerializedName("beer_id") private long mBeerId;
    @SerializedName("price") private float mPrice;
    @SerializedName("abv") private float mAlcoholByVolume;
    @SerializedName("on_sale") private boolean mOnSale;

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(final ImageView imageView, final String imageUrl) {
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(final String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSize() {
        return mSize;
    }

    public void setSize(final String size) {
        mSize = size;
        notifyPropertyChanged(BR.size);
    }

    @Bindable
    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        mImageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public String getCategory() {
        return mCategory;
    }

    public void setCategory(final String category) {
        mCategory = category;
        notifyPropertyChanged(BR.category);
    }

    @Bindable
    public String getType() {
        return mType;
    }

    public void setType(final String type) {
        mType = type;
        notifyPropertyChanged(BR.type);
    }

    @Bindable
    public String getBrewer() {
        return mBrewer;
    }

    public void setBrewer(final String brewer) {
        mBrewer = brewer;
        notifyPropertyChanged(BR.brewer);
    }

    @Bindable
    public String getCountry() {
        return mCountry;
    }

    public void setCountry(final String country) {
        mCountry = country;
        notifyPropertyChanged(BR.country);
    }

    @Bindable
    public long getId() {
        return mId;
    }

    public void setId(final long id) {
        mId = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public long getBeerId() {
        return mBeerId;
    }

    public void setBeerId(final long beerId) {
        mBeerId = beerId;
        notifyPropertyChanged(BR.beerId);
    }

    @Bindable
    public float getPrice() {
        return mPrice;
    }

    public void setPrice(final float price) {
        mPrice = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public float getAlcoholByVolume() {
        return mAlcoholByVolume;
    }

    public void setAlcoholByVolume(final float alcoholByVolume) {
        mAlcoholByVolume = alcoholByVolume;
        notifyPropertyChanged(BR.alcoholByVolume);
    }

    @Bindable
    public boolean isOnSale() {
        return mOnSale;
    }

    public void setOnSale(final boolean onSale) {
        mOnSale = onSale;
        notifyPropertyChanged(BR.onSale);
    }
}
