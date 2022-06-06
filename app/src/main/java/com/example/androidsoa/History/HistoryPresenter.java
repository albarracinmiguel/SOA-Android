package com.example.androidsoa.History;

import com.example.androidsoa.data.MyDatabase;

public class HistoryPresenter implements IHistory.Presenter {

    private IHistory.View view;
    private IHistory.Model model;

    private static String TAG = HistoryPresenter.class.getName();

    public HistoryPresenter(IHistory.View view, MyDatabase database) {
        this.view = view;
        model = new HistoryModel(database);
    }

    public void loadLogins(){
        view.loadLogins(model.getLogins());
    }
}
