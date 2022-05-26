package com.example.androidsoa.Signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidsoa.Services.SoaRequest;

import com.example.androidsoa.R;
import com.example.androidsoa.Login.LoginView;

import java.util.List;

public class SignupView extends AppCompatActivity implements ISignup.View {

    private EditText name;
    private EditText lastName;
    private EditText password;
    private EditText dni;
    private EditText commission;
    private EditText email;
    private EditText group;
    private ISignup.Presenter presenter;
    private ISignup.Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = (EditText)findViewById(R.id.NameTxt);
        lastName = (EditText)findViewById(R.id.LastNameTxt);
        email = (EditText)findViewById(R.id.EmailTxt);
        dni = (EditText)findViewById(R.id.DniTxt);
        commission = (EditText)findViewById(R.id.ComissionTxt);
        group = (EditText)findViewById(R.id.GroupTxt);
        password = (EditText)findViewById(R.id.PasswordSignupTxt);

        repository = new SignupRepository(this.getApplicationContext());
        presenter = new SignupPresenter(this, repository);
    }

    @Override
    public void moveToLogin(View view) {
        //startActivity(new Intent(SignupView.this, LoginView.class));
        presenter.getList();

    }

    @Override
    public void signupSuccess() {
        //startActivity(new Intent(SignupView.this, LoginView.class));
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signupFail() {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void register(View view){
        SoaRequest soaRequest = new SoaRequest(name.getText().toString(), lastName.getText().toString(),
                email.getText().toString(), password.getText().toString(), dni.getText().toString(), commission.getText().toString(),
                group.getText().toString());
        presenter.registerUser(soaRequest);
    }
}