package com.example.androidsoa.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidsoa.network.SOAService.SOAApi;
import com.example.androidsoa.network.SOAService.SOARequest;

import com.example.androidsoa.R;
import com.example.androidsoa.Login.LoginView;
import com.example.androidsoa.data.MyDatabase;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SignupView extends DaggerAppCompatActivity implements ISignup.View {

    private EditText name;
    private EditText lastName;
    private EditText password;
    private EditText dni;
    private EditText commission;
    private EditText email;
    private EditText group;
    private EditText userName;

    @Inject
    MyDatabase database;

    @Inject
    SOAApi soaApi;

    private static final String TAG = "SignupView";
    private ISignup.Presenter presenter;

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
        userName = (EditText)findViewById(R.id.userNameSignupTxt);

        presenter = new SignupPresenter(this, soaApi, database);
    }

    @Override
    public void moveToLogin(View view) {
//        startActivity(new Intent(SignupView.this, LoginView.class));
        presenter.getList();

    }

    @Override
    public void signupSuccess() {
        startActivity(new Intent(SignupView.this, LoginView.class));
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signupFail() {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void register(View view){
        SOARequest soaRequest = new SOARequest(name.getText().toString(), lastName.getText().toString(),
                email.getText().toString(), password.getText().toString(), dni.getText().toString(), commission.getText().toString(),
                group.getText().toString());
        presenter.registerUser(soaRequest);
    }
}