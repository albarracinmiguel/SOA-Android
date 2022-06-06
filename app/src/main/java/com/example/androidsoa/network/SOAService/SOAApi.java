package com.example.androidsoa.network.SOAService;

import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;
import com.example.androidsoa.network.SOAService.Response.SOARegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SOAApi {

    @POST("/register")
    Call<SOARegisterResponse> register(@Body SOARegisterRequest request);
}
