package com.enciyo.toolbarimageadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.enciyo.enciyoappbarlayout.CustomView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CustomView enciyo;
    ArrayList<String> arrayList;
    ImageButton mImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
