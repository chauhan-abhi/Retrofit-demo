package io.futurestud.retrofit1.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import io.futurestud.retrofit1.BuildConfig;
import io.futurestud.retrofit1.R;
import io.futurestud.retrofit1.api.model.Stock;
import io.futurestud.retrofit1.api.service.StockClient;
import io.futurestud.retrofit1.ui.adapter.StockAdapter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …


        if(BuildConfig.DEBUG) {
            // add logging as last interceptor
            httpClient.addInterceptor(logging);  //

        }
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://192.168.0.119:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());

        Retrofit retrofit = builder.build();

        //GET implementation

       /* StockClient client=retrofit.create(StockClient.class);
        Call<List<Stock>> call =  client.stocksforuser();


        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {
                List<Stock> stocks = response.body();
               // Log.v("respm" ,response.body().toString());
                listView.setAdapter(new StockAdapter(MainActivity.this, stocks));
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {

            }
        });*/

       //POST implementaion
        Stock stock=new Stock("hp",1.2f,4.5f,100);
        StockClient client = retrofit.create(StockClient.class);
        Call<Stock> call = client.createStock(stock);
        call.enqueue(new Callback<Stock>() {
            @Override
            public void onResponse(Call<Stock> call, Response<Stock> response) {
                Toast.makeText(MainActivity.this, "New Stock Posted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Stock> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Posting toast Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
