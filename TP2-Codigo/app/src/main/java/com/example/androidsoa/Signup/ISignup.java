package com.example.androidsoa.Signup;

import com.example.androidsoa.Dto.UserDto;
import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;

import java.util.List;

public interface ISignup {
    interface View {
        void moveToLogin(android.view.View view);

        void signupSuccess(String secret);

        void signupFail(String msg);

        void showNetworkError(String msg);

        void register(android.view.View view);
    }

    interface Presenter {
        void registerUser(SOARegisterRequest soaRequest, String userName);
    }

    interface Model {
        void addUser(SOARegisterRequest contact, String userName, String secret);
    }
}
