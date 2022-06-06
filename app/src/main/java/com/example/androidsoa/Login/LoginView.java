package com.example.androidsoa.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidsoa.Principal.PrincipalView;
import com.example.androidsoa.R;
import com.example.androidsoa.Signup.ISignup;
import com.example.androidsoa.Signup.SignupView;
import com.example.androidsoa.data.MyDatabase;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class LoginView extends DaggerAppCompatActivity implements ILogin.View{

    private TextView error;
    private EditText username;
    private EditText password;
    private ILogin.Presenter presenter;
    private Button loginFirst;
    private Button signupBtn;
    private Button loginSecond;
    private EditText otpText;
    @Inject
    MyDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.UsernameTxt);
        password = (EditText)findViewById(R.id.PasswordTxt);
        otpText = (EditText)findViewById(R.id.OTPtxt);
        loginFirst = (Button)findViewById(R.id.LoginBtn);
        loginSecond = (Button)findViewById(R.id.CheckOTPBtn);
        signupBtn = (Button)findViewById(R.id.SignupBtn);
        error = (TextView) findViewById(R.id.ErrorTxt);
        presenter = new LoginPresenter(this, database);
    }

    public void login(View view){
        error.setVisibility(View.INVISIBLE);
        presenter.checkUser(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showError(String result) {
        error.setVisibility(View.VISIBLE);
        error.setText(result);
    }

    @Override
    public void showOTP() {
        error.setVisibility(View.INVISIBLE);
        loginFirst.setVisibility(View.INVISIBLE);
        signupBtn.setVisibility(View.INVISIBLE);
        username.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        loginSecond.setVisibility(View.VISIBLE);
        otpText.setVisibility(View.VISIBLE);
    }



    public void moveToPrincipal(){
        startActivity(new Intent(LoginView.this, PrincipalView.class));
    }

    public void moveToSignup(View view){
        startActivity(new Intent(LoginView.this, SignupView.class));
    }

    @Override
    public void loginOTP(View view) {
        presenter.checkValidOTP(otpText.getText().toString());
    }
}