package io.futurestud.retrofit1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import io.futurestud.retrofit1.R;
import io.futurestud.retrofit1.api.model.Stock;
import io.futurestud.retrofit1.api.service.StockClient;
import io.futurestud.retrofit1.ui.adapter.StockAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.pagination_list);


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.0.119:8000/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        StockClient client1=retrofit.create(StockClient.class);
        Call<List<Stock>> call1 =  client1.stocksforuser();

        
        call1.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {
                List<Stock> stocks = response.body();
                listView.setAdapter(new StockAdapter(MainActivity.this, stocks));
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {

            }
        });
    }

}
