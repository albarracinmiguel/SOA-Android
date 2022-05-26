package com.example.androidsoa.Signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.androidsoa.Services.SoaRequest;

import java.util.ArrayList;
import java.util.List;

public class SignupRepository extends SQLiteOpenHelper implements ISignup.Repository{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ContactsDB";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LASTNAME = "lastName";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_DNI = "dni";
    private static final String KEY_COMMISSION = "comission";
    private static final String KEY_GROUP = "groupNumber";


    public SignupRepository(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_LASTNAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_DNI + " TEXT,"
                + KEY_COMMISSION + " TEXT,"
                + KEY_GROUP + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        // Create tables again
        onCreate(db);
    }

    @Override
    public void addContact(SoaRequest contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_LASTNAME, contact.getLastName());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_PASSWORD, contact.getPassword());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    @Override
    public List<SoaRequest> getAllContacts() {
        List<SoaRequest> contactList = new ArrayList<SoaRequest>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SoaRequest contact = new SoaRequest();
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
