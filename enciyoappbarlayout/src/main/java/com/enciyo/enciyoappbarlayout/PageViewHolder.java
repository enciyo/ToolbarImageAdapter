package com.enciyo.enciyoappbarlayout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PageViewHolder extends RecyclerView.ViewHolder {

    protected PageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void initView(String url){
        ImageView imageView = itemView.findViewById(R.id.pager_imageView);
        Glide.with(itemView).load(url).into(imageView);
    }
}

