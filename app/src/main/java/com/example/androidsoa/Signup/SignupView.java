package com.example.androidsoa.Signup;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidsoa.network.SOAService.SOAApi;
import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;

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
        startActivity(new Intent(SignupView.this, LoginView.class));
    }

    @Override
    public void signupSuccess(String secret) {
        name.setVisibility(View.INVISIBLE);
        lastName.setVisibility(View.INVISIBLE);
        email.setVisibility(View.INVISIBLE);
        dni.setVisibility(View.INVISIBLE);
        commission.setVisibility(View.INVISIBLE);
        group.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        userName.setVisibility(View.INVISIBLE);
        TextView nameLabel = (TextView) findViewById(R.id.labelName);
        nameLabel.setVisibility(View.INVISIBLE);
        TextView lastNameLabel = (TextView) findViewById(R.id.labelApellido);
        lastNameLabel.setVisibility(View.INVISIBLE);
        TextView emailLabel = (TextView) findViewById(R.id.labelEmail);
        emailLabel.setVisibility(View.INVISIBLE);
        TextView dniLabel = (TextView) findViewById(R.id.labelDni);
        dniLabel.setVisibility(View.INVISIBLE);
        TextView comissionLabel = (TextView) findViewById(R.id.labelComission);
        comissionLabel.setVisibility(View.INVISIBLE);
        TextView groupLabel = (TextView) findViewById(R.id.labelGroup);
        groupLabel.setVisibility(View.INVISIBLE);
        TextView passwordLabel = (TextView) findViewById(R.id.labelPassword);
        passwordLabel.setVisibility(View.INVISIBLE);
        TextView usernameLabel = (TextView) findViewById(R.id.labelUsername);
        usernameLabel.setVisibility(View.INVISIBLE);
        TextView secretLabel = (TextView) findViewById(R.id.labelSecret);
        secretLabel.setVisibility(View.VISIBLE);
        secretLabel.setText("Su clave para google authenticator es: \n" + secret + "\nguardelo y use google authenticator para ingresar a la app");
        Button btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setVisibility(View.INVISIBLE);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", secret);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Secret copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signupFail() {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void register(View view){
        SOARegisterRequest SOARegisterRequest = new SOARegisterRequest(
                "TEST",
                name.getText().toString(),
                lastName.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                Long.parseLong(dni.getText().toString()),
                Long.parseLong(commission.getText().toString()),
                Long.parseLong(group.getText().toString())
        );
        presenter.registerUser(SOARegisterRequest);
    }
}