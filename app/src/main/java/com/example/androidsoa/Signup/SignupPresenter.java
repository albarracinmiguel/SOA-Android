package com.example.androidsoa.Signup;

import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.example.androidsoa.Services.ISoaService;
import com.example.androidsoa.Services.SoaRequest;
import com.example.androidsoa.Services.SoaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupPresenter implements  ISignup.Presenter {
    private ISignup.View view;
    private ISignup.Model model;
    private static String TAG = SignupPresenter.class.getName();

    public SignupPresenter(ISignup.View view){
        this.view = view;
        this.model = new SignupModel(this);
    }

    @Override
    public void registerUser(SoaRequest soaRequest) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://so-unlam.net.ar/api/").build();
        ISoaService soaService = retrofit.create(ISoaService.class);
        Call<SoaResponse> call = soaService.register(soaRequest);
        call.enqueue(new Callback<SoaResponse>() {
            @Override
            public void onResponse(Call<SoaResponse> call, Response<SoaResponse> response) {
                if (response.isSuccessful()){
                    view.signupSuccess();
                }
                else {
                    view.signupFail();
                }
                Log.e(TAG, response.message());
            }

            @Override
            public void onFailure(Call<SoaResponse> call, Throwable t) {
                view.signupFail();
                Log.e(TAG, t.getMessage());
            }
        });
    }

}
