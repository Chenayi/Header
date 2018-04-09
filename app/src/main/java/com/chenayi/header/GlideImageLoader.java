package com.chenayi.header;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Chenwy on 2018/4/8.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .apply(new RequestOptions()
                        .centerCrop()
                        .placeholder(R.color.white))
                .into(imageView);
    }
}
