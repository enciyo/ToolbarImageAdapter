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
        enciyo = (CustomView) findViewById(R.id.enciyo);
        setSupportActionBar(enciyo.getmToolbar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrayList = new ArrayList<>();
        arrayList.add("https://cdn.shopify.com/s/files/1/0797/1743/articles/Slash_76b50290-8dab-4ee2-b862-b95b0032fd63_2048x.progressive.jpg");
        arrayList.add("https://peakup.org/wp-content/uploads/2018/01/lg-smart-video-eye-recognition.jpg");
        arrayList.add("https://townsquare.media/site/295/files/2018/06/Slash_Myles_feature.jpg");
        arrayList.add("https://cdn.shopify.com/s/files/1/0797/1743/articles/Slash_76b50290-8dab-4ee2-b862-b95b0032fd63_2048x.progressive.jpg");
        arrayList.add("https://peakup.org/wp-content/uploads/2018/01/lg-smart-video-eye-recognition.jpg");
        arrayList.add("https://townsquare.media/site/295/files/2018/06/Slash_Myles_feature.jpg");

        enciyo.setAdapter(arrayList);
        enciyo.setTitle("Title");
        enciyo.setSubTitle("Subtitle");
        enciyo.setmImageButton(mImageButton);
        enciyo.getmImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"sada",Toast.LENGTH_LONG).show();
            }
        });



    }
}
