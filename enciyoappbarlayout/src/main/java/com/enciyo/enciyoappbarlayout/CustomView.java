package com.enciyo.enciyoappbarlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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

public class CustomView extends AppBarLayout implements AppBarLayout.OnOffsetChangedListener {

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
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

    private ArrayList<String> mArrayList = new ArrayList<>();
    private LinearLayout mImageLinear;
    private Paint mPaint;
    private Rect mRect;



    private void init(AttributeSet attrs) {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRect = new Rect();

        mViewPager = mView.findViewById(R.id.viewPager);
        title = mView.findViewById(R.id.title);
        subtitle = mView.findViewById(R.id.title2);
        mLinearLayout = mView.findViewById(R.id.linear);
        mFrameLayout = mView.findViewById(R.id.frameLayout);
        toolbar = mView.findViewById(R.id.myCustomToolbar);
        mImageButton = mView.findViewById(R.id.imageButton);
        mImageLinear = mView.findViewById(R.id.imageLinear);

        this.setBackgroundColor(Color.parseColor("#000000"));
        this.addOnOffsetChangedListener(this);

        if(attrs !=  null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.CustomView);


            if(typedArray.getString(R.styleable.CustomView_appBarTitle)!=null){
                this.title.setText(typedArray.getString(R.styleable.CustomView_appBarTitle));
            }
            if(typedArray.getString(R.styleable.CustomView_appBarSubtitle)!= null ){
                this.subtitle.setText(typedArray.getString(R.styleable.CustomView_appBarSubtitle));
            }

                this.title.setTextColor(typedArray.getColor(R.styleable.CustomView_appbarTitleColor,Color.WHITE));
                this.subtitle.setTextColor(typedArray.getColor(R.styleable.CustomView_appbarSubTitleColor,Color.WHITE));
                this.toolbar.setBackgroundColor(typedArray.getColor(R.styleable.CustomView_toolbar_color,Color.TRANSPARENT));

            typedArray.recycle();


        }




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRect.left = 0;
        mRect.right = getWidth();
        mRect.top = 0;
        mRect.bottom = getHeight();

        canvas.drawRect(mRect, mPaint);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int toltalRange = getTotalScrollRange();
        if (toltalRange + verticalOffset <= toltalRange / 2) {
            Float progress = ((float) (toltalRange + verticalOffset) / (toltalRange / 2));
            mFrameLayout.setAlpha(progress);
            mLinearLayout.setAlpha(1-progress);
            toolbar.setAlpha(1-progress);
        } else {
            mFrameLayout.setAlpha(1);
            mLinearLayout.setAlpha(0);
            toolbar.setAlpha(0);
        }


    }

    public void setAdapter(final ArrayList<String> arrayList,final ArrayList<String> title, final ArrayList<String> subtitle) {
        Observable.fromCallable(new Callable() {
            @Override
            public Object call() throws Exception {
                mPagerAdapter = new PagerAdapter(arrayList,title,subtitle);
                mViewPager.setAdapter(mPagerAdapter);
                mIndicator = mView.findViewById(R.id.viewpager_pager_indicator);
                mIndicator.attachToViewPager(mViewPager);
                mViewPager.setPageTransformer(false, new PageSwitchTransformer());
                return mViewPager;
            }
        })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    public void setAdapter(final ArrayList<String> arrayList) {
        Observable.fromCallable(new Callable() {
            @Override
            public Object call() throws Exception {
                mPagerAdapter = new PagerAdapter(arrayList);
                mViewPager.setAdapter(mPagerAdapter);
                mIndicator = mView.findViewById(R.id.viewpager_pager_indicator);
                mIndicator.attachToViewPager(mViewPager);
                mViewPager.setPageTransformer(false, new PageSwitchTransformer());
                return mViewPager;
            }
        })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }



    public void addImage(final String url) {
        Observable.fromCallable(new Callable() {
            @Override
            public Object call() throws Exception {
                mArrayList.add(url);
                mViewPager.setAdapter(new PagerAdapter(mArrayList));
                mIndicator = mView.findViewById(R.id.viewpager_pager_indicator);
                mIndicator.attachToViewPager(mViewPager);
                mViewPager.setPageTransformer(false, new PageSwitchTransformer());
                return mViewPager;
            }
        })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSubTitle(String subTitle) {
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
