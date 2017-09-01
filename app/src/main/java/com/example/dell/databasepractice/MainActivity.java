package com.example.dell.databasepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_email,et_id;
    Button btn_insert,btn_update,btn_delete,btn_show;

    protected String id,name,email;

    private DBHandler dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHandler(getApplicationContext());

        et_name = (EditText)findViewById(R.id.et_name);
        et_email = (EditText)findViewById(R.id.et_email);
        et_id = (EditText)findViewById(R.id.et_id);
        btn_insert = (Button)findViewById(R.id.btn_insert);
        btn_update = (Button)findViewById(R.id.btn_update);
        btn_delete = (Button)findViewById(R.id.btn_delete);
        btn_show = (Button)findViewById(R.id.btn_show);

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = et_name.getText().toString();
                id = et_id.getText().toString();
                email = et_email.getText().toString();




                dbHelper.addStudent(et_id.getText().toString(),et_name.getText().toString(),et_email.getText().toString());




                Toast.makeText(MainActivity.this,"Record inserted.!",Toast.LENGTH_SHORT).show();

            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this,"Record is here.!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),ShowDetails.class);
                startActivity(intent);
            }
        });

    }

}
