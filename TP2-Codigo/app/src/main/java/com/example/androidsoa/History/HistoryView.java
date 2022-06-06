package com.example.androidsoa.History;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidsoa.Principal.PrincipalView;
import com.example.androidsoa.R;
import com.example.androidsoa.data.HistoryLogin;
import com.example.androidsoa.data.MyDatabase;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


public class HistoryView extends DaggerAppCompatActivity implements IHistory.View{

    private TextView history;
    private IHistory.Presenter presenter;

    @Inject
    MyDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        history = (TextView)findViewById(R.id.HistorialTxt);
        presenter = new HistoryPresenter(this, database);
        presenter.loadLogins();
    }

    public void loadLogins(List<HistoryLogin> logins){
        for(HistoryLogin histoyItem : logins){
            history.append("Usuario: " + histoyItem.username + " Date: " + histoyItem.date + ".\n");
        }
    }

    public void backToPrincipal(View view){
        startActivity(new Intent(HistoryView.this, PrincipalView.class));
    }
}