package com.example.test_gridview;

public class My_Card {
    String name;
    Integer imageResource;
    My_Card(String name, Integer imageResource)
    {
        this.name=name;
        this.imageResource=imageResource;
    }

    public String getName() {
        return this.name;
    }

    public Integer getImageResource() {
        return this.imageResource;
    }
}
