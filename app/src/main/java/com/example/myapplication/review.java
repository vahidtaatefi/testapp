package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        final TextView txtname=findViewById(R.id.txtname);
        final TextView txtfamily=findViewById(R.id.txtfamily);
        final TextView txtmail=findViewById(R.id.txtmail);
        final TextView txtage=findViewById(R.id.txtage);
        Button btnok=findViewById(R.id.btnok);
        Button btnedit=findViewById(R.id.btnedit);
        Intent i=getIntent();
        txtname.setText(i.getStringExtra("name"));
        txtfamily.setText(i.getStringExtra("family"));
        txtmail.setText(i.getStringExtra("mail"));
        txtage.setText(i.getStringExtra("age"));
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.putExtra("name",txtname.getText().toString());
                i.putExtra("family",txtfamily.getText().toString());
                i.putExtra("mail",txtmail.getText().toString());
                i.putExtra("age",txtage.getText().toString());
                setResult(profileset.RESULT_OK,i);
                finish();
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                setResult(profileset.RESULT_CANCELED);
                finish();
            }
        });

    }






}
