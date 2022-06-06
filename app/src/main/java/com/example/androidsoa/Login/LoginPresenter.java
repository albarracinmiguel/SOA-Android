package com.example.androidsoa.Login;

import android.util.Log;

import com.example.androidsoa.data.MyDatabase;
import com.example.androidsoa.network.SOAService.Request.SOALoginRequest;
import com.example.androidsoa.network.SOAService.Response.SOARegisterResponse;
import com.example.androidsoa.network.SOAService.SOAApi;
import com.example.androidsoa.util.ErrorConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements ILogin.Presenter {

    private ILogin.View view;
    private ILogin.Model model;
    private final SOAApi soaApi;
    private static String TAG = LoginPresenter.class.getName();

    public LoginPresenter(ILogin.View view, MyDatabase database, SOAApi soaApi) {
        this.view = view;
        model = new LoginModel(this, database);
        this.soaApi = soaApi;
    }

    @Override
    public void showResult(boolean result) {
        if (view != null) {
            if (result) {
                view.moveToPrincipal();
            } else {
                view.showError(ErrorConstants.INVALID_LOGIN);
            }
        }
    }

    @Override
    public void showOTP() {
        view.showOTP();
    }

    @Override
    public void checkUser(String username, String password) {
        if (view != null) {
            model.checkUser(username, password);
        }
    }

    @Override
    public void checkValidOTP(String otp) {
        if (model.checkOtp(otp)){
            model.saveLogin();
            view.moveToPrincipal();
        }
        else
            view.showError(ErrorConstants.INVALID_LOGIN);
    }

    public void login(SOALoginRequest soaLoginRequest) {
        Call<SOARegisterResponse> call = soaApi.login(soaLoginRequest);
        call.enqueue(new Callback<SOARegisterResponse>() {
            @Override
            public void onResponse(Call<SOARegisterResponse> call, Response<SOARegisterResponse> response) {
                if (response.isSuccessful()) {
                    SOARegisterResponse soaRegisterResponse = response.body();

                    view.moveToPrincipal();
                } else {
                    Log.e(TAG, response.message());
                    view.showError(ErrorConstants.INVALID_LOGIN);
                }
            }

            @Override
            public void onFailure(Call<SOARegisterResponse> call, Throwable t) {
                view.showError(ErrorConstants.INVALID_LOGIN);
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
