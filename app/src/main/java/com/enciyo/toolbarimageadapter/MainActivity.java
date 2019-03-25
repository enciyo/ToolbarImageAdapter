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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList = new ArrayList<>();
        enciyo = findViewById(R.id.enciyo);

        arrayList.add("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        arrayList.add("https://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg");
        arrayList.add("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        arrayList.add("https://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg");
        arrayList.add("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        arrayList.add("https://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg");
        arrayList.add("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        arrayList.add("https://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg");

        for (int i =0;i<arrayList.size();i++){
            enciyo.setAdapter(arrayList.get(i));
        }

    }
}
