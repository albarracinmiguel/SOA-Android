package com.example.androidsoa.Signup;

import android.util.Log;

import com.example.androidsoa.network.SOAService.SOAApi;
import com.example.androidsoa.network.SOAService.SOARequest;
import com.example.androidsoa.network.SOAService.SOAResponse;
import com.example.androidsoa.data.MyDatabase;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupPresenter implements  ISignup.Presenter {
    private ISignup.View view;
    private ISignup.Model model;
    private static String TAG = SignupPresenter.class.getName();

    private final SOAApi soaApi;

    public SignupPresenter(ISignup.View view, SOAApi soaApi, MyDatabase database){
        this.soaApi = soaApi;
        this.view = view;
        this.model = new SignupModel(this, database);
    }

    @Override
    public void registerUser(SOARequest soaRequest) {
        model.addContact(soaRequest);
        Call<SOAResponse> call = soaApi.register(soaRequest);
        call.enqueue(new Callback<SOAResponse>() {
            @Override
            public void onResponse(Call<SOAResponse> call, Response<SOAResponse> response) {
                if (response.isSuccessful()){
                    view.signupSuccess();
                }
                else {
                    view.signupFail();
                }
                Log.e(TAG, response.message());
            }

            @Override
            public void onFailure(Call<SOAResponse> call, Throwable t) {
                view.signupFail();
                Log.e(TAG, t.getMessage());
            }
        });
    }

    @Override
    public void getList() {
        List<SOARequest> aux = model
                .getAllContacts();
        for (SOARequest contact: aux) {
            Log.i(TAG, contact.getName());
        }

    }

}
