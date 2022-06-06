package com.example.androidsoa.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "ContactsDB";
    private static final String TABLE_USERS = "users";
    private static final String TABLE_HISTORY = "loginHistory";
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_SECRET = "otpSecret";
    private static final String KEY_DATE = "date";

    @Inject
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SOA_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USERNAME + " TEXT, "
                + KEY_PASSWORD + " TEXT,"
                + KEY_SECRET + " TEXT)";
        db.execSQL(CREATE_SOA_USER_TABLE);

        String CREATE_LOGIN_HISTORY_TABLE = "CREATE TABLE " + TABLE_HISTORY + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USERNAME + " TEXT, "
                + KEY_DATE + " DATETIME)";
        db.execSQL(CREATE_LOGIN_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    public void addSoaUser(SOARegisterRequest contact, String userName, String secret) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, userName);
        values.put(KEY_PASSWORD, contact.getPassword());
        values.put(KEY_SECRET, secret);

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public void addLogin(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, userName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        values.put(KEY_DATE, dateFormat.format(date));

        db.insert(TABLE_HISTORY, null, values);

        db.close();
    }

    public SOAUser getSoaUser(String username) {
        String selectQuery = "SELECT * FROM " + TABLE_USERS + " WHERE " + KEY_USERNAME + " = '" + username + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        SOAUser user = new SOAUser();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            // contact.setID(Integer.parseInt(cursor.getString(0)));
            user.userName = cursor.getString(1);
            user.password = cursor.getString(2);
            user.otpSecret = cursor.getString(3);
        }
        // return contact list
        return user;
    }

    public List<HistoryLogin> getLoginHistory() {
        List<HistoryLogin> loginsList = new ArrayList<HistoryLogin>();
        String selectQuery = "SELECT  * FROM " + TABLE_HISTORY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HistoryLogin login = new HistoryLogin();
                login.username = cursor.getString(1);
                login.date = cursor.getString(2);
                loginsList.add(login);
            } while (cursor.moveToNext());
        }
        return loginsList;
    }
}
