package com.example.androidsoa.Signup;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
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
import com.example.androidsoa.util.Constants;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class SignupView extends DaggerAppCompatActivity implements ISignup.View {

    private EditText name;
    private EditText lastName;
    private EditText password;
    private EditText identificationNumber;
    private EditText commission;
    private EditText email;
    private EditText group;
    private EditText userName;
    private TextView labelError;

    @Inject
    MyDatabase database;

    @Inject
    SOAApi soaApi;

    private ISignup.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.NameEditTxt);
        lastName = (EditText) findViewById(R.id.LastNameEditTxt);
        identificationNumber = (EditText) findViewById(R.id.IdentificationNumberEditTxt);
        commission = (EditText) findViewById(R.id.CommissionEditTxt);
        group = (EditText) findViewById(R.id.GroupEditTxt);
        email = (EditText) findViewById(R.id.EmailEditTxt);
        userName = (EditText) findViewById(R.id.userEditTxt);
        password = (EditText) findViewById(R.id.PasswordEditTxt);
        labelError = findViewById(R.id.labelError);

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
        identificationNumber.setVisibility(View.INVISIBLE);
        commission.setVisibility(View.INVISIBLE);
        group.setVisibility(View.INVISIBLE);
        password.setVisibility(View.INVISIBLE);
        userName.setVisibility(View.INVISIBLE);
        TextView nameLabel = (TextView) findViewById(R.id.NameTxt);
        nameLabel.setVisibility(View.INVISIBLE);
        TextView lastNameLabel = (TextView) findViewById(R.id.LastNameTxt);
        lastNameLabel.setVisibility(View.INVISIBLE);
        TextView emailLabel = (TextView) findViewById(R.id.EmailTxt);
        emailLabel.setVisibility(View.INVISIBLE);
        TextView dniLabel = (TextView) findViewById(R.id.IdentificationNumberTxt);
        dniLabel.setVisibility(View.INVISIBLE);
        TextView comissionLabel = (TextView) findViewById(R.id.CommissionTxt);
        comissionLabel.setVisibility(View.INVISIBLE);
        TextView groupLabel = (TextView) findViewById(R.id.GroupTxt);
        groupLabel.setVisibility(View.INVISIBLE);
        TextView passwordLabel = (TextView) findViewById(R.id.PasswordTxt);
        passwordLabel.setVisibility(View.INVISIBLE);
        TextView usernameLabel = (TextView) findViewById(R.id.userTxt);
        usernameLabel.setVisibility(View.INVISIBLE);
        TextView secretLabel = (TextView) findViewById(R.id.labelSecret);
        secretLabel.setVisibility(View.VISIBLE);
        secretLabel.setText("Su clave para google authenticator es: \n" + secret + "\nguardelo y use google authenticator para ingresar a la app");
        Button registerBtn = (Button) findViewById(R.id.RegisterBtn);
        registerBtn.setVisibility(View.INVISIBLE);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", secret);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Secret copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signupFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void showNetworkError(String msg) {
        this.labelError.setVisibility(View.VISIBLE);
        this.labelError.setTextColor(ColorStateList.valueOf(0xFFFF0000));
        this.labelError.setText(msg);
    }

    @Override
    public void register(View view) {
        SOARegisterRequest SOARegisterRequest = new SOARegisterRequest(
                Constants.ENV_PROD,
                name.getText().toString(),
                lastName.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                Long.parseLong(identificationNumber.getText().toString()),
                Long.parseLong(commission.getText().toString()),
                Long.parseLong(group.getText().toString())
        );

        presenter.registerUser(SOARegisterRequest, userName.getText().toString());
    }
}