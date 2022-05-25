package com.example.androidsoa.Services;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ISoaService {

    @POST("api/register")
    Call<SoaResponse> register(@Body SoaRequest request);
}
