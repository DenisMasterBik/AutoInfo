package com.example.sasha.autoinfo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;


public class MenuCars extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars_menu);
        final Item item = new Item();

        Intent intent = getIntent();
        final String result = intent.getStringExtra("key");
        listView = (ListView) findViewById(R.id.listView);
        if (result.equals(MainActivity.CAR)) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item.getCars());
        } else {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item.getBus());
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (result.equals(MainActivity.CAR)) {
                    fileRead(position, item.getImageCar(), item.getCars());
                } else {
                    fileRead(position, item.getImageBus(), item.getBus());
                }
            }
        });
    }

    private void fileRead(int position, int[] image, String[] model) {
        String text = "text/" + model[position] + ".txt";

        byte[] buffer = null;
        InputStream is;
        try

        {
            is = getAssets().open(text);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        String str_data = new String(buffer);
        System.out.println(str_data);
        Intent intent = new Intent(MenuCars.this, AboutCar.class);
        intent.putExtra("text", str_data);
        intent.putExtra("image", image[position]);
        startActivity(intent);
    }


}
