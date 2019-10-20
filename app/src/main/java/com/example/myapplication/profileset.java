package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profileset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileset);
        Button btnreview=findViewById(R.id.btnreview);
        final EditText edtname=findViewById(R.id.edtname);
        final EditText edtfamily=findViewById(R.id.edtfamily);
        final EditText edtmail=findViewById(R.id.edtmail);
        final EditText edtage=findViewById(R.id.edtage);


        edtname.setText(PreferenceManager.getDefaultSharedPreferences(profileset.this).getString("name",""));
        edtfamily.setText(PreferenceManager.getDefaultSharedPreferences(profileset.this).getString("family",""));
        edtmail.setText(PreferenceManager.getDefaultSharedPreferences(profileset.this).getString("mail",""));
        edtage.setText(PreferenceManager.getDefaultSharedPreferences(profileset.this).getString("age",""));
        btnreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(profileset.this,review.class);
                i.putExtra("name",edtname.getText().toString());
                i.putExtra("family",edtfamily.getText().toString());
                i.putExtra("mail",edtmail.getText().toString());
                i.putExtra("age",edtage.getText().toString());
                startActivityForResult(i,352);
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 352  && resultCode  == RESULT_OK) {

            PreferenceManager.getDefaultSharedPreferences(profileset.this).edit().putString("name",data.getStringExtra("name")).apply();
            PreferenceManager.getDefaultSharedPreferences(profileset.this).edit().putString("family",data.getStringExtra("family")).apply();
            PreferenceManager.getDefaultSharedPreferences(profileset.this).edit().putString("mail",data.getStringExtra("mail")).apply();
            PreferenceManager.getDefaultSharedPreferences(profileset.this).edit().putString("age",data.getStringExtra("age")).apply();
            Toast.makeText(profileset.this,"register your data successfull",Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(profileset.this,"re enter your data Please",Toast.LENGTH_LONG).show();
        }
    }
}
