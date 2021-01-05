package com.example.quakedec;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EarthQuakeData {
    private final Double scale;
    private final String place;
    private final String date;


    public String getScale() {
        return scale.toString();
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        Date date =new Date(this.date);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy HH:mm a");
        return dateFormatter.format(date);
    }

    public EarthQuakeData(Double scale, String place, String date) {
        this.scale = scale;
        this.place = place;
        this.date = date;
    }
    public String getTime()
    {
        return null;
    }
}
