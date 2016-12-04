package com.example.sasha.autoinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

// повесим обработчик на только что созданные кнопки.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {/* */
    Button cars, bus, version, history, exit;
    static final String CAR = "car";
    static final String BUS = "bus";
    String historyFact;
    private static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {/* */
        super.onCreate(savedInstanceState);/* */
        setContentView(R.layout.activity_main);/* */
        history = (Button) findViewById(R.id.history);
        cars = (Button) findViewById(R.id.cars);
        bus = (Button) findViewById(R.id.bus);
        version = (Button) findViewById(R.id.version);/* */
        exit = (Button) findViewById(R.id.exit);

        history.setOnClickListener(this);
        cars.setOnClickListener(this);
        bus.setOnClickListener(this);
        version.setOnClickListener(this);/* */
        exit.setOnClickListener(this);

        MenuCars menuCars = new MenuCars();
        historyFact = fileRead("HIS Fact");
    }

    @Override/* */
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.history:
                Intent intent3 = new Intent(this, AboutCar.class);
                intent3.putExtra("text", historyFact);
                intent3.putExtra("image", R.drawable.zazlogo);
                startActivity(intent3);
                break;
            case R.id.cars:
                Intent intent = new Intent(this, MenuCars.class);
                intent.putExtra(KEY, CAR);
                startActivity(intent);
                break;
            case R.id.bus:
                Intent intent1 = new Intent(this, MenuCars.class);
                intent1.putExtra(KEY, BUS);
                startActivity(intent1);
                break;
            case R.id.version:
                Toast.makeText(this, "Версия 1.01, Автор: Denis Reshetnov", Toast.LENGTH_SHORT).show();/* выводит версию программы*/
                break;
            case R.id.exit:
                finish();
                break;
            default:
                break;
        }
    }

    public String fileRead(String model) {
        String text = "text/" + model + ".txt";
        Log.d("TAG", text);
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


        return new String(buffer);
    }
}

