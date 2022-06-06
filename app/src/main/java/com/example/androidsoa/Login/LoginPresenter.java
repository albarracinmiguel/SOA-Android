package com.example.androidsoa.Login;

import com.example.androidsoa.data.MyDatabase;
import com.example.androidsoa.util.ErrorConstants;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base32;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex;

import de.taimos.totp.TOTP;

public class LoginPresenter implements ILogin.Presenter {

    private ILogin.View view;
    private ILogin.Model model;

    public LoginPresenter(ILogin.View view, MyDatabase database) {
        this.view = view;
        model = new LoginModel(this, database);
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
        if( model.checkOtp(otp))
            view.moveToPrincipal();
        else
            view.showError(ErrorConstants.INVALID_LOGIN);
    }
}
