package com.example.dell.databasepractice;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowDetails extends AppCompatActivity {

    private DBHandler dbHelper;
    private Cursor cursor;
    String merge;
    ArrayList<String> studentDetails;
    ListView studentDetailsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        dbHelper = new DBHandler(this);
        studentDetails = new ArrayList<>();
       studentDetailsList = (ListView)findViewById(R.id.studentDetailsList);

        cursor = dbHelper.showData();

        if (cursor.moveToFirst()) {

            do {

                String strID = cursor.getString(cursor.getColumnIndex(DBHandler.KEY_ID));
                String strName = cursor.getString(cursor.getColumnIndex(DBHandler.KEY_NAME));
                String strEmail = cursor.getString(cursor.getColumnIndex(DBHandler.KEY_EMAIL));
                merge = "Student ID : "+strID+"\nName : "+strName+"\nEmail : "+strEmail+" ";
                studentDetails.add(merge);


                //Toast.makeText(this, "Values are\n ID :"+strID+" \n Name :" + strName + "\n Email :" + strEmail, Toast.LENGTH_LONG).show();

            } while (cursor.moveToNext());

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.row,R.id.showDetails_id ,studentDetails);

        studentDetailsList.setAdapter(arrayAdapter);
        cursor.close();



    }
}
