package net.android.uasakb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//10119266
//Ahmad Haris
//IF-7
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context ) {
        super(context, "Catatan.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Catatandetails(note TEXT primary key, kategori TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Catatandetails");
    }
    public Boolean simpancatatan(String note, String kategori){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("note", note);
        contentValues.put("kategori", kategori);
        long result=DB.insert("Catatandetails", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
}
