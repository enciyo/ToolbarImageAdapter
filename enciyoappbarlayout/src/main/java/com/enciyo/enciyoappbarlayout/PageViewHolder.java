package com.enciyo.enciyoappbarlayout;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PageViewHolder extends RecyclerView.ViewHolder {

    protected PageViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void initView(String url){
        ImageView imageView = itemView.findViewById(R.id.pager_imageView);
        Glide.with(itemView).load(url).into(imageView);
    }

    public void initView(String url,String title){
        ImageView imageView = itemView.findViewById(R.id.pager_imageView);
        TextView textTitle = itemView.findViewById(R.id.imageTitle);
        Glide.with(itemView).load(url).into(imageView);
        textTitle.setText(title);

    }

    public void initView(String url,String title,String subtitle){
        ImageView imageView = itemView.findViewById(R.id.pager_imageView);
        TextView textTitle = itemView.findViewById(R.id.imageTitle);
        TextView textSubtitle = itemView.findViewById(R.id.imageSubtitle);
        textTitle.setBackgroundColor(Color.TRANSPARENT);
        textSubtitle.setBackgroundColor(Color.TRANSPARENT);



        textTitle.setText(title);
        textSubtitle.setText(subtitle);
        Glide.with(itemView).load(url).into(imageView);



    }





}

