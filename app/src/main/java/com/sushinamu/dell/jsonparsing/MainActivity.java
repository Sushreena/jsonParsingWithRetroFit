package com.sushinamu.dell.jsonparsing;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        //progress dialogue

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        getMenuJson();
    }

    public void getMenuJson(){

        RetrofitApiInterface retrofitApiInterface = RetrofitClient.getRetrofit().create(RetrofitApiInterface.class);
        retrofit2.Call<List<MenuModalClass>> modalClassCall = retrofitApiInterface.getMenu();
        modalClassCall.enqueue(new Callback<List<MenuModalClass>>() {
            @Override
            public void onResponse(retrofit2.Call<List<MenuModalClass>> call, Response<List<MenuModalClass>> response) {
                //forst way
                //List<MenuModalClass> menuModalClasses = response.body();
                //RecyclerViewAdapterClass recyclerViewAdapterClass = new RecyclerViewAdapterClass(MainActivity.this,menuModalClasses);

                //second way
                RecyclerViewAdapterClass recyclerViewAdapterClass = new RecyclerViewAdapterClass(MainActivity.this,response.body());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

                // horizontal scroll
                //LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                //recyclerView.setLayoutManager(horizontalLayoutManager);

                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(recyclerViewAdapterClass);
                recyclerViewAdapterClass.notifyDataSetChanged();

                if (progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<List<MenuModalClass>> call, Throwable t) {

            }
        });
    }
}
