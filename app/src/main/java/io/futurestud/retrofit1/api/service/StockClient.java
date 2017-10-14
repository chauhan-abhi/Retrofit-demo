package io.futurestud.retrofit1.api.service;

import java.util.List;

import io.futurestud.retrofit1.api.model.Stock;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by abhi on 13/10/17.
 */

public interface StockClient {

    @GET("/stocks/")
    Call<List<Stock>> stocksforuser();

    @POST("stocks/")
    Call<Stock> createStock(@Body Stock stock);
}
