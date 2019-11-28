package com.example.scanner.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.scanner.Model.ListItem;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "barcode";
    private static final String DB_NAME = "barcode.db";
    private static final String COL_ID = "id";
    private static final String COL_CODE = "code";
    private static final String COL_TYPE = "type";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "code TEXT, type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String code, String type) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CODE, code);
        contentValues.put(COL_TYPE, type);
        SQLiteDatabase db = this.getWritableDatabase();
        long results = db.insert(TABLE_NAME, null, contentValues);

        if (results == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<ListItem> getAllInformation() {
        ArrayList<ListItem> arrayList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from " + TABLE_NAME, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String code = cursor.getString(1);
                String type = cursor.getString(2);
                ListItem listItem = new ListItem(id, code, type);
                arrayList.add(listItem);
            }
        }
        cursor.close();
        return arrayList;
    }

    public void deleteRow(int value) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COL_ID + " = " + value + "");
    }
}
