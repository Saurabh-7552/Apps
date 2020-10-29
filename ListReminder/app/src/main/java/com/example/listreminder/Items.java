package com.example.listreminder;

public class Items {
    private String item;
    private Integer number;


    public Items(String item, int number) {
        this.item = item;
        this.number = number;
    }

    public String getItem() {
        return item;
    }

    public String getNumber() {
        return number.toString() + ".";
    }
    public int getIntegerNumber()
    {
        return this.number;
    }


}
