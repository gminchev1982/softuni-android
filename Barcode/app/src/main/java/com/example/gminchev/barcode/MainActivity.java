package com.example.gminchev.barcode;


import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gminchev.barcode.data.AppDatabase;
import com.example.gminchev.barcode.data.ProductEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_barcode)    TextView txtBarcode;
    @BindView(R.id.btn_search)     Button btnSearch;
    @BindView(R.id.txt_code)       TextView txtCode;
    @BindView(R.id.txt_product)    TextView txtProduct;
    @BindView(R.id.txt_gredient)   TextView txtGredient;
    AppDatabase db;
    ProductEntity data;
    private final static String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "prodcode.db").build();
    }

    @OnClick(R.id.btn_search)
    public void onSearch() {
        final String barcode = txtBarcode.getText().toString();
        Log.e(TAG,String.valueOf(barcode));
        new AsyncTask<Void, Void, ProductEntity>() {
            @Override
            protected ProductEntity doInBackground(Void... params) {

                Log.e(TAG,String.valueOf(barcode));
                return db.ProductDao().searchBarcode(barcode);
            }

            @Override
            protected void onPostExecute(ProductEntity dbResult) {
                //Log.e( " DbResult", String.valueOf(dbResult.getCode()));
                data = dbResult;
                if (dbResult != null) {
                    displayData(dbResult);
                } else {
                    Log.e("DBRESULT",String.valueOf(dbResult));


                    getSearchData(barcode);
                }
            }
        }.execute();

    }

    private void getSearchData(String barcode) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ProductService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ProductService service = retrofit.create(ProductService.class);

        service.getProductData(barcode).enqueue(new Callback<ProductEntity>() {
            @Override
            public void onResponse(Call<ProductEntity> call, Response<ProductEntity> response) {

                if (response.isSuccessful()) {
                    data = response.body();
                    Log.e("getCode:",data.getCode());
                    Log.e("GETSTATUS",String.valueOf(data.getStatus()));

                    if (data.getStatus()!=0) insertInDb(data);
                    displayData(data);
                }

            }

            @Override
            public void onFailure(Call<ProductEntity> call, Throwable t) {
                    Log.e(TAG, "Failure");
            }


        });
    }


    public void insertInDb(final ProductEntity data) {

        //  prdEntity.setProduct_name("karakuza");
        // prdEntity.setIngredient("spsps");

        Toast.makeText(this, "Data ", Toast.LENGTH_SHORT).show();
        new AsyncTask<Long, Void, Long>() {
            @Override
            protected Long doInBackground(Long... params) {
                Long ids = db.ProductDao().insert(data);
                Log.e ("dddd", String.valueOf(ids));
                return ids;
            }

            @Override
            protected void onPostExecute(Long res) {
                Log.e(TAG, String.valueOf(res));

                if (res != null) {
                    //2: If it already exists then prompt user
                    Toast.makeText(MainActivity.this, "Barcode inserted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Barcode Failed Insert:)", Toast.LENGTH_SHORT).show();
                    //onBackPressed();
                    //getDataAPI(barcode);
                }
            }
        }.execute();
    }

    public void displayData(ProductEntity data) {
        String code = data.getCode();
        int status = data.getStatus();
        Log.e(TAG, String.valueOf(status));
        if (status==1) {
            txtCode.setText(data.getCode());
        } else {
            txtCode.setText("Not found!");
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }

    }

}
