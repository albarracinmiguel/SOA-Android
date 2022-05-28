package com.example.androidsoa.network.SOAService;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SOAApi {

    @POST("api/register")
    Call<SOAResponse> register(@Body SOARequest request);
}
