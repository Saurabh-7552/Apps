package com.example.testdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String mDbName ="Student.db";
    private static final String mTableName ="StudentTable";
    private static final String mName ="Name";
    private static final String mSurname ="Surname";
    private static final String mMarks ="Marks";
    public DataBaseHelper(Context context) {
        super(context,mDbName,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      sqLiteDatabase.execSQL("Create Table "+mTableName+" (ID Integer PRIMARY Key Autoincrement,NAME TEXT, SURNAME TEXT, MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+mTableName);
      onCreate(sqLiteDatabase);
    }
    public boolean InsertData(String name,String Surname,Integer Marks)
    {
        SQLiteDatabase mDB=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put(mName,name);
        contentValues.put(mSurname,Surname);
        contentValues.put(mMarks,Marks);
        return mDB.insert(mTableName, null, contentValues) != -1;
    }
    public Cursor getData()
    {
        SQLiteDatabase mDB =this.getWritableDatabase();
        return mDB.rawQuery("SELECT * FROM "+mTableName,null);
    }
    public void deleteTable()
    {
        SQLiteDatabase mDB =this.getWritableDatabase();
        mDB.rawQuery("DELETE FROM sqlite_sequence WHERE name= "+mTableName,null);
        mDB.delete(mTableName,"1",null);
        mDB.rawQuery("DELETE  FROM "+mTableName,null);
        mDB.close();

    }

}
