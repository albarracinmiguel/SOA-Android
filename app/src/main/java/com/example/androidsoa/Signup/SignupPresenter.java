package com.example.androidsoa.Signup;

import android.util.Log;

import com.example.androidsoa.Dto.UserDto;
import com.example.androidsoa.network.SOAService.SOAApi;
import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;
import com.example.androidsoa.network.SOAService.Response.SOARegisterResponse;
import com.example.androidsoa.data.MyDatabase;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base32;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex;

import java.security.SecureRandom;
import java.util.List;

import javax.inject.Inject;

import de.taimos.totp.TOTP;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupPresenter implements ISignup.Presenter {
    private ISignup.View view;
    private ISignup.Model model;
    private static String TAG = SignupPresenter.class.getName();

    private final SOAApi soaApi;

    public SignupPresenter(ISignup.View view, SOAApi soaApi, MyDatabase database) {
        this.soaApi = soaApi;
        this.view = view;
        this.model = new SignupModel(this, database);
    }

    @Override
    public void registerUser(SOARegisterRequest soaRegisterRequest, String userName) {
        String secret = generateSecretKey();
        model.addContact(soaRegisterRequest);
        model.addUser(soaRegisterRequest, userName, secret);
        Call<SOARegisterResponse> call = soaApi.register(soaRegisterRequest);
        call.enqueue(new Callback<SOARegisterResponse>() {
            @Override
            public void onResponse(Call<SOARegisterResponse> call, Response<SOARegisterResponse> response) {
                if (response.isSuccessful()) {
                    SOARegisterResponse soaRegisterResponse = response.body();

                    System.out.println("SUCCESS");
                    System.out.println(soaRegisterResponse.getSuccess());
                    System.out.println(soaRegisterResponse.getToken());
                    System.out.println(soaRegisterResponse.getTokenRefresh());
                    System.out.println(soaRegisterResponse.getEnv());

                    view.signupSuccess(secret);
                } else {
                    System.out.println("ERROR");
                    System.out.println(response.message());
                    Log.e(TAG, response.message());
                    view.signupFail();
                }
            }

            @Override
            public void onFailure(Call<SOARegisterResponse> call, Throwable t) {
                System.out.println("FAILURE");
                view.signupFail();
                Log.e(TAG, t.getMessage());
            }
        });

        view.signupSuccess(secret);
    }

    @Override
    public void getList() {
        List<SOARegisterRequest> aux = model
                .getAllContacts();
        for (SOARegisterRequest contact : aux) {
            Log.i(TAG, contact.getName());
        }

    }

    public static String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        return base32.encodeToString(bytes);
    }

}
