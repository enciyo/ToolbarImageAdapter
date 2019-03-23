package com.enciyo.enciyoappbarlayout;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

public class PageSwitchTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View view, float v) {
        ImageView image = view.findViewById(R.id.pager_imageView);
        image.setTranslationX(-v * view.getWidth());
    }
}
