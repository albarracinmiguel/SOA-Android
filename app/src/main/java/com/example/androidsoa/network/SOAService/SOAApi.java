package com.example.androidsoa.network.SOAService;

import com.example.androidsoa.network.SOAService.Request.SOALoginRequest;
import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;
import com.example.androidsoa.network.SOAService.Response.SOARegisterResponse;
import com.example.androidsoa.util.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SOAApi {

    @Headers({"content-Type: application/json", "x-csrf-token: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NTQ1MzI0MTAsInR5cGUiOiJpbmljaWFsIiwidXNlciI6eyJlbWFpbCI6InRlc3RAZ21haWwuY29tIiwiZG5pIjoxMjM0NTY3OCwiZ3JvdXAiOjF9fQ.L7c-SG6kdoUpv-LtAsQBJ45zvvFajFJa8DRIWdLwYn0"})
    @POST(Constants.SOA_API + "register")
    Call<SOARegisterResponse> register(@Body SOARegisterRequest request);

    @Headers({"Content-Type: application/json"})
    @POST(Constants.SOA_API + "login")
    Call<SOARegisterResponse> login(@Body SOALoginRequest request);

    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer"
    })
    @POST(Constants.SOA_API + "event")
    Call<SOARegisterResponse> createEvent(@Body SOARegisterRequest request);
}
