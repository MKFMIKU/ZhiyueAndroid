package com.kffuck.mikum.zhiyue;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class GridActivity extends LinearLayout {

    public GridActivity(Context context) {
        this(context, null);
    }

    public GridActivity(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.custom_grid, this, true);

        ImageView banner = (ImageView) findViewById(R.id.bannerGrid);
        ImageView itemOne = (ImageView) findViewById(R.id.itemOneGrid);
        ImageView itemTwo = (ImageView) findViewById(R.id.itemTwoGrid);
        ImageView itemThree = (ImageView) findViewById(R.id.itemThreeGrid);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(configuration);

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage("drawable://" + R.drawable.cg0, banner);
        imageLoader.displayImage("drawable://" + R.drawable.cg1, itemOne);
        imageLoader.displayImage("drawable://" + R.drawable.cg2, itemTwo);
        imageLoader.displayImage("drawable://" + R.drawable.cg3, itemThree);
    }
}
