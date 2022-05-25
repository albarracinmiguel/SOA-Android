package com.example.androidsoa.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidsoa.Principal.PrincipalView;
import com.example.androidsoa.R;
import com.example.androidsoa.Signup.SignupView;

public class LoginView extends AppCompatActivity implements ILogin.View{

    private TextView error;
    private EditText username;
    private EditText password;
    private ILogin.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.UsernameTxt);
        password = (EditText)findViewById(R.id.PasswordTxt);
        error = (TextView) findViewById(R.id.ErrorTxt);
        presenter = new LoginPresenter(this);
    }

    public void login(View view){
        error.setVisibility(View.INVISIBLE);
        presenter.checkUser(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showResult(String result) {
        error.setVisibility(View.VISIBLE);
        error.setText(result);
    }

    public void moveToPrincipal(){
        startActivity(new Intent(LoginView.this, PrincipalView.class));
    }

    public void moveToSignup(View view){
        startActivity(new Intent(LoginView.this, SignupView.class));
    }
}