package io.futurestud.retrofit1.api.model;

/**
 * Created by abhi on 13/10/17.
 */

public class Stock {



    private int id;
    private String ticker;
    private float open1;
    private float close;
    private float volume;

    public Stock(String ticker, float open1, float close, float volume) {
        this.ticker = ticker;
        this.open1 = open1;
        this.close = close;
        this.volume = volume;
    }

    public float getOpen1() {
        return open1;
    }

    public float getClose() {
        return close;
    }

    public float getVolume() {
        return volume;
    }

    ;public int getId() { return id; }

    public String getTicker() {
        return ticker;
    }



}
