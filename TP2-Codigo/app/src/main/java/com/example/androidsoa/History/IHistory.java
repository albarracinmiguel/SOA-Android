package com.example.androidsoa.History;

import android.view.View;

import com.example.androidsoa.data.HistoryLogin;

import java.util.List;

public interface IHistory {
    interface View {
        void loadLogins(List<HistoryLogin> logins);
        void backToPrincipal(android.view.View view);
    }
    interface Presenter{
        void loadLogins();
    }
    interface Model{
        List<HistoryLogin> getLogins();
    }
}
