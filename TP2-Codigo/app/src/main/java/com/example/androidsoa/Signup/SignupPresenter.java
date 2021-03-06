package com.example.androidsoa.Signup;

import android.util.Log;

import com.example.androidsoa.data.MyDatabase;
import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;
import com.example.androidsoa.network.SOAService.Response.SOARegisterResponse;
import com.example.androidsoa.network.SOAService.SOAApi;
import com.example.androidsoa.util.ErrorConstants;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base32;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupPresenter implements ISignup.Presenter {
    private ISignup.View view;
    private ISignup.Model model;
    private final SOAApi soaApi;
    private static String TAG = SignupPresenter.class.getName();

    public SignupPresenter(ISignup.View view, SOAApi soaApi, MyDatabase database) {
        this.soaApi = soaApi;
        this.view = view;
        this.model = new SignupModel(this, database);
    }

    @Override
    public void registerUser(SOARegisterRequest soaRegisterRequest, String userName) {
        Call<SOARegisterResponse> call = soaApi.register(soaRegisterRequest);
        call.enqueue(new Callback<SOARegisterResponse>() {
            @Override
            public void onResponse(Call<SOARegisterResponse> call, Response<SOARegisterResponse> response) {
                if (response.isSuccessful()) {
                    String secret = generateSecretKey();
                    model.addUser(soaRegisterRequest, userName, secret);

                    SOARegisterResponse soaRegisterResponse = response.body();
                    view.signupSuccess(secret);
                } else {
                    Log.e(TAG, response.message());
                    view.signupFail(ErrorConstants.REGISTER_ERROR);
                }
            }

            @Override
            public void onFailure(Call<SOARegisterResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    view.showNetworkError(ErrorConstants.NETWORK_ERROR);
                } else {
                    view.signupFail(t.getMessage());
                }

                Log.e(TAG, t.getMessage());
            }
        });
    }

    public static String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        return base32.encodeToString(bytes);
    }

}
