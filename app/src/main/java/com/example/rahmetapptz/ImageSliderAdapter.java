package com.example.rahmetapptz;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageSliderAdapter extends PagerAdapter {
    private List<String> mImagesUrl;
    private LayoutInflater mInflater;
    private Context mContext;

    public ImageSliderAdapter(Context context) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }
    public void setImagesUrl(List<String> imagesUrl) {
        mImagesUrl = imagesUrl;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mImagesUrl.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        View imageLayout = mInflater.inflate(R.layout.sliding_image, view, false);
        ImageView imageView = imageLayout.findViewById(R.id.branchImage);
        TextView indicator = imageLayout.findViewById(R.id.text_indicator);
        Picasso.with(mContext).load(mImagesUrl.get(position)).into(imageView);
        String imagesCounter = (position + 1) + "/" + mImagesUrl.size();
        indicator.setText(imagesCounter);
        view.addView(imageLayout);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
