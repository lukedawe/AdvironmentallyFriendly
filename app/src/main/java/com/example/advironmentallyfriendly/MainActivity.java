package com.example.myapplication;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ViewFlipper v_flipper;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Images in drawable
        int images[] = {R.drawable.page01,R.drawable.page02,R.drawable.page03,R.drawable.page04,R.drawable.page05,R.drawable.page06,R.drawable.page07,R.drawable.page08,R.drawable.page09,R.drawable.page10,R.drawable.page11,R.drawable.page12,R.drawable.page13,R.drawable.page15,R.drawable.page16,R.drawable.page18,R.drawable.page19};

        v_flipper= findViewById(R.id.v_flipper);

        for(int image: images){

            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        // Changes every X seconds so change this number
        v_flipper.setFlipInterval(10000);
        v_flipper.setAutoStart(true);
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

}