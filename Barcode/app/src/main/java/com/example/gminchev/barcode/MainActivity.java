package com.example.gminchev.barcode;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_barcode)
    TextView txtBarcode;
    @BindView(R.id.btn_search)
    Button btnSearch;
    private final static String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_search)
    public void onSearch() {
        Log.e(TAG, "ClickSearch");

        String barcode = "7376280645502"; //txtBarcode.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ProductService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductService service = retrofit.create(ProductService.class);
        Log.e(TAG, "ClickSearch 2");
        service.getProductData(barcode).enqueue(new Callback <Product>() {
            @Override
            public void onResponse(Call <Product> call, Response <Product> response) {
                Log.e(TAG, "Is : " + response.isSuccessful());
                if (response.isSuccessful()) {
                    Product data = response.body();
                    Log.e(TAG, "ddddd : "  + data.toString());
                }

            }

            @Override
            public void onFailure(Call <Product> call, Throwable t) {
                Log.e(TAG, "FAILERE");
                Log.e(TAG, t.toString());
            }
        });


    }

}
