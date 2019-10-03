package com.tejas.v_authmachinetest.main.api;

import com.tejas.v_authmachinetest.main.model.mainResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.tejas.v_authmachinetest.main.api.JsonKeys.KEY_API_KEY;
import static com.tejas.v_authmachinetest.main.api.JsonKeys.KEY_COUNTRY;

public interface ApiInterface {

    @GET("top-headlines")
    Call<mainResponse> getList(@Query(KEY_COUNTRY) String county, @Query(KEY_API_KEY) String apiKey);

}
