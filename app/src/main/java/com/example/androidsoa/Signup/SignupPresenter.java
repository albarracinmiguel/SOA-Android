package com.example.androidsoa.Signup;

import android.util.Log;

import com.example.androidsoa.Services.ISoaService;
import com.example.androidsoa.Services.SoaRequest;
import com.example.androidsoa.Services.SoaResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupPresenter implements  ISignup.Presenter {
    private ISignup.View view;
    private ISignup.Model model;
    private ISignup.Repository repository;
    private static String TAG = SignupPresenter.class.getName();

    public SignupPresenter(ISignup.View view, ISignup.Repository repository){
        this.view = view;
        this.model = new SignupModel(this);
        this.repository = repository;
    }

    @Override
    public void registerUser(SoaRequest soaRequest) {
        repository.addContact(soaRequest);
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

    @Override
    public void getList() {
        List<SoaRequest> aux = repository.getAllContacts();
        for (SoaRequest contact: aux) {
            Log.i(TAG, contact.getName());
        }

    }

}
