package com.example.sasha.autoinfo;

/**
 * Created by Alexandr.
 */
public class Item {
    private String[] cars = {
            "ZAZ 965",
            "ZAZ 966", "ZAZ 968", "ZAZ 968 A", "ZAZ 968 M",
            "ZAZ 969",
            "ZAZ 1102", "ZAZ Slavuta", "ZAZ 11055",
            "ZAZ Lanos", "ZAZ Forza", "ZAZ Vida"
    };
    private int[] imageCar = {R.drawable.zaz965, R.drawable.zaz966, R.drawable.zaz968,
            R.drawable.zaz968a, R.drawable.zaz968m, R.drawable.zaz969,
            R.drawable.zaz1102, R.drawable.zazslavuta, R.drawable.zaz11055,
            R.drawable.zazlanos, R.drawable.zazforza, R.drawable.zazvida};

    private String[] bus = {
            "ZAZ A10", "ZAZ A07A"
    };
    private int[] imageBus = {
            R.drawable.zaz10, R.drawable.zaz07a
    };

    public String[] getCars() {
        return cars;
    }

    public int[] getImageCar() {
        return imageCar;
    }

    public String[] getBus() {
        return bus;
    }

    public int[] getImageBus() {
        return imageBus;
    }
}
