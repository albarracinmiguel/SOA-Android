package com.example.androidsoa.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidsoa.Dto.UserDto;
import com.example.androidsoa.network.SOAService.Request.SOARegisterRequest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "ContactsDB";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String TABLE_USERS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_NAME = "name";
    private static final String KEY_LASTNAME = "lastName";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_DNI = "dni";
    private static final String KEY_COMMISSION = "comission";
    private static final String KEY_GROUP = "groupNumber";
    private static final String KEY_SECRET = "otpSecret";


    @Inject
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USERNAME + "TEXT, "
                + KEY_NAME + " TEXT,"
                + KEY_LASTNAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_DNI + " TEXT,"
                + KEY_COMMISSION + " TEXT,"
                + KEY_GROUP + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

        String CREATE_SOA_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USERNAME + " TEXT, "
                + KEY_PASSWORD + " TEXT,"
                + KEY_SECRET + " TEXT)";
        db.execSQL(CREATE_SOA_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Create tables again
        onCreate(db);
    }

    public void addContact(SOARegisterRequest user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getName());
        values.put(KEY_LASTNAME, user.getLastName());
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public void addSoaUser(SOARegisterRequest contact, String secret) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, contact.username);
        values.put(KEY_PASSWORD, contact.getPassword());
        values.put(KEY_SECRET, secret);

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
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

    public List<SOARegisterRequest> getAllContacts() {
        List<SOARegisterRequest> contactList = new ArrayList<SOARegisterRequest>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SOARegisterRequest contact = new SOARegisterRequest();
                // contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setEnv("TEST");
                contact.setName(cursor.getString(1));
                contact.setLastName(cursor.getString(2));
                contact.setEmail(cursor.getString(3));
                contact.setPassword(cursor.getString(4));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        // return contact list
        return contactList;
    }
}
