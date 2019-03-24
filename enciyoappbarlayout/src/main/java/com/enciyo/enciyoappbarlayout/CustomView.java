package com.enciyo.enciyoappbarlayout;

import android.content.Context;
import android.graphics.Color;
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
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
    private TextView title;
    private TextView subtitle;
    private android.support.v7.widget.Toolbar toolbar;
    private ImageButton mImageButton;
    private TextView imageTitle;
    private TextView imageSubTitle;


    public void setImageTitle(String imageTitle) {
        this.imageTitle.setText(imageTitle);
    }

    public void setImageSubTitle(String imageSubTitle) {
        this.imageSubTitle.setText(imageSubTitle);
    }

    private void init() {
        mViewPager = mView.findViewById(R.id.viewPager);
        title = mView.findViewById(R.id.title);
        subtitle = mView.findViewById(R.id.title2);
        mLinearLayout = mView.findViewById(R.id.linear);
        mFrameLayout = mView.findViewById(R.id.frameLayout);
        toolbar = mView.findViewById(R.id.myCustomToolbar);
        mImageButton = mView.findViewById(R.id.imageButton);
        imageTitle = mView.findViewById(R.id.imageTitle);
        imageSubTitle = mView.findViewById(R.id.imageSubtitle);

        this.setBackgroundColor(Color.parseColor("#f4f4f4"));
        this.addOnOffsetChangedListener(this);


    }



    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        Float progress=  -i / (float) appBarLayout.getTotalScrollRange();
        mFrameLayout.setAlpha(1-progress);
        mLinearLayout.setAlpha(progress);

    }

    public void setAdapter(ArrayList<String> arrayList) {
        mPagerAdapter = new PagerAdapter(arrayList);
        Observable.fromCallable(new Callable() {
            @Override
            public Object call() throws Exception {
                mViewPager.setAdapter(mPagerAdapter);
                mIndicator = mView.findViewById(R.id.viewpager_pager_indicator);
                mIndicator.attachToViewPager(mViewPager);
                mViewPager.setPageTransformer(false,new PageSwitchTransformer());
                return mViewPager;
            }
        })
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe();

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSubTitle(String subTitle){
        this.subtitle.setText(subTitle);
    }

    public Toolbar getToolbar() {
        return toolbar;
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
