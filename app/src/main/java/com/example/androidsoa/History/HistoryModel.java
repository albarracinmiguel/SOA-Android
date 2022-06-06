package com.example.androidsoa.History;

import com.example.androidsoa.data.HistoryLogin;
import com.example.androidsoa.data.MyDatabase;

import java.util.List;

public class HistoryModel implements IHistory.Model {

    private MyDatabase database;

    public HistoryModel(MyDatabase database) {
        this.database = database;
    }

    public List<HistoryLogin> getLogins(){
        return database.getLoginHistory();
    }
}