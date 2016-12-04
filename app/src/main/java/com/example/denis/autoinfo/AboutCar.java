package com.example.sasha.autoinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by denja_000 on 06.05.2016.
 */
public class AboutCar extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars_item);
        TextView tv = (TextView) findViewById(R.id.text_about_car);
        ImageView carsImage = (ImageView) findViewById(R.id.image_car_item);
        Intent intent = getIntent();
        String text = intent.getStringExtra("text");
        int image = intent.getIntExtra("image", -1);
        if (tv != null && carsImage != null) {
            tv.setText(text);
            carsImage.setImageResource(image);
        }
    }
}
