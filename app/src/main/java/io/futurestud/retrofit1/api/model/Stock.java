package io.futurestud.retrofit1.api.model;

/**
 * Created by abhi on 13/10/17.
 */

public class Stock {

    private String ticker;
    private float open1;
    private float close;
    private float volume;


    public float getOpen1() {
        return open1;
    }

    public float getClose() {
        return close;
    }

    public float getVolume() {
        return volume;
    }



    public String getTicker() {
        return ticker;
    }



}
