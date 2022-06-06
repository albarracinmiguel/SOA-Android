package com.example.androidsoa.Login;

import com.example.androidsoa.data.MyDatabase;
import com.example.androidsoa.data.SOAUser;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Base32;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex;

import de.taimos.totp.TOTP;

public class LoginModel implements ILogin.Model{
    private ILogin.Presenter presenter;
    private MyDatabase database;
    public static SOAUser user;

    public LoginModel(ILogin.Presenter presenter, MyDatabase database){
        this.presenter = presenter;
        this.database = database;
    }

    @Override
    public void checkUser(String username, String password) {
        user = database.getSoaUser(username);
        if(user.password != null && user.password.equals(password))
        {
            presenter.showOTP();
        }
        else{
            presenter.showResult(false);
        }
    }

    @Override
    public boolean checkOtp(String otp) {
        if(getTOTPCode().equals(otp))
            return true;
        else
            return false;
    }

    private static String getTOTPCode() {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(user.otpSecret);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }
}
