package com.sushinamu.dell.jsonparsing;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {
    @GET("api.php")
    Call<List<MenuModalClass>> getMenu();
}
