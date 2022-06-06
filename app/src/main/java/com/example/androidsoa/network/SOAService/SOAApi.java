package com.example.androidsoa.network.SOAService;

import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;
import com.example.androidsoa.network.SOAService.Response.SOARegisterResponse;
import com.example.androidsoa.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SOAApi {

    @Headers("Content-Type: application/json")
    @POST(Constants.SOA_API + "register")
    Call<SOARegisterResponse> register(@Body SOARegisterRequest request);
}
