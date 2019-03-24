package com.enciyo.enciyoappbarlayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import java.util.ArrayList;

public class CustomView extends AppBarLayout implements AppBarLayout.OnOffsetChangedListener {

    public CustomView(Context context) {
        super(context);
        init();
    }
    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private View mView = LayoutInflater.from(getContext()).inflate(R.layout.customview, this, true);
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private LinearLayout mLinearLayout;
    private IndefinitePagerIndicator mIndicator;
    private FrameLayout mFrameLayout;
    private TextView mTitle;
    private TextView mSubtitle;
    private android.support.v7.widget.Toolbar mToolbar;
    private ImageButton mImageButton;



    private void init() {
        mViewPager = mView.findViewById(R.id.viewPager);
        mTitle = mView.findViewById(R.id.title);
        mSubtitle = mView.findViewById(R.id.title2);
        mLinearLayout = mView.findViewById(R.id.linear);
        mFrameLayout = mView.findViewById(R.id.frameLayout);
        mToolbar = mView.findViewById(R.id.myCustomToolbar);
        mImageButton = mView.findViewById(R.id.imageButton);
        //
        this.setBackgroundColor(Color.parseColor("#f4f4f4"));
    }



    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Float progress=  -i / (float) appBarLayout.getTotalScrollRange();
        mFrameLayout.setAlpha(1-progress);
        mLinearLayout.setAlpha(progress);

    }

    public void setAdapter(ArrayList<String> arrayList) {
        mPagerAdapter = new PagerAdapter(arrayList);
        this.addOnOffsetChangedListener(this);
        mViewPager.setAdapter(mPagerAdapter);
        mIndicator = mView.findViewById(R.id.viewpager_pager_indicator);
        mIndicator.attachToViewPager(mViewPager);
        mViewPager.setPageTransformer(false,new PageSwitchTransformer());
    }

    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    public void setSubTitle(String subTitle){
        this.mSubtitle.setText(subTitle);
    }

    public Toolbar getmToolbar() {
        return mToolbar;
    }

    @Override
    public View getRootView() {
        return (AppBarLayout) mView;
    }

    public Toolbar setmToolbar(Toolbar toolbar) {
        return toolbar;
    }

    public void setmImageButton(ImageButton mImageButton) {
        this.mImageButton = mImageButton;
    }

    public ImageButton getmImageButton() {
        return mImageButton;
    }
}
