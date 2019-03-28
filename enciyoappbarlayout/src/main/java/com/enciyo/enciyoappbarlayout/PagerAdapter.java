package com.enciyo.enciyoappbarlayout;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

class PagerAdapter  extends android.support.v4.view.PagerAdapter {

    private ArrayList<String> arrayList;
    private ArrayList<String> title;
    private ArrayList<String> subtitle;

    PagerAdapter(ArrayList<String> arrayList){
        this.arrayList=arrayList;
    }
    PagerAdapter(ArrayList<String> arrayList,ArrayList<String> title,ArrayList<String> subtitle){
        this.arrayList=arrayList;
        this.title = title;
        this.subtitle=subtitle;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout) o );
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View mView = LayoutInflater.from(container.getContext()).inflate(R.layout.item_adapter,container,false);
        PageViewHolder holder = new PageViewHolder(mView);

        if(title!=null && subtitle !=null){
            holder.initView(arrayList.get(position),title.get(position),subtitle.get(position));
        }else
        {
            holder.initView(arrayList.get(position));

        }
        container.addView(mView,0);
        return mView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
