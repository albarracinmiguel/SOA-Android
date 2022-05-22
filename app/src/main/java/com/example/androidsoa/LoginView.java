package com.example.androidsoa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
        presenter.checkUser(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showResult(String result) {
        error.setText(result);
    }
}