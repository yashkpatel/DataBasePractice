package com.example.dell.databasepractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    EditText name,email;
    Button insert,update,delete,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.et_name);
        email = (EditText)findViewById(R.id.et_email);
        insert = (Button)findViewById(R.id.btn_insert);
        update = (Button)findViewById(R.id.btn_update);
        delete = (Button)findViewById(R.id.btn_delete);
        show = (Button)findViewById(R.id.btn_show);
    }
}
