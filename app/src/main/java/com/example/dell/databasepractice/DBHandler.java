package com.example.dell.databasepractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 29-08-2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "StudentInfo";

    //Student Table name
    private static final String TABLE_STUDENT = "Student";

    //Student Table column name
    protected static final String KEY_ID = "id";
    protected static final String KEY_NAME = "name";
    protected static final String KEY_EMAIL = "email";

    //Required resources to manage database
    private SQLiteDatabase db=null;
    private ContentValues values;
    private Cursor cursor;

public  DBHandler(Context context)
{
    super(context,DATABASE_NAME,null,DATABASE_VERSION);
}

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table query
        String CREATE_STUDENT_TABLE = "CREATE TABLE "+TABLE_STUDENT+"("+KEY_ID+" INTEGER PRIMARY KEY,"+ KEY_NAME +" TEXT,"+KEY_EMAIL+" TEXT)";

        //execution of create table query
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    //db upgrade
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //If table with same name exist then delete it.
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT);

        //Create new table
        onCreate(db);
    }

    //Adding a new student
    public void addStudent(String id, String name, String email){

        db = this.getWritableDatabase();

        values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_NAME,name);
        values.put(KEY_EMAIL,email);

        db.insert(TABLE_STUDENT,null,values);
        db.close();
    }

    //Show data from database
    public Cursor showData(){

        db = getReadableDatabase();

        //Getting data from database table
        cursor = db.rawQuery("Select * from "+TABLE_STUDENT,null);
        return cursor;
    }

}
