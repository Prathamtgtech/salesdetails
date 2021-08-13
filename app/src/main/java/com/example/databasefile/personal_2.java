package com.example.databasefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import static android.content.ContentValues.TAG;

public class personal_2 extends AppCompatActivity {
Spinner occupation;
TextView next,previous,demo;
TextInputEditText Education,CompanyName,Designation,WorkNature,BLocation;
String education,companyname,designation,worknature,busiloc;
    String occupations[]={"Salary","Business","Professional","Retired","Student"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal2);
        Bundle bundle=getIntent().getExtras();
        occupation=findViewById(R.id.spinner);

       next=(TextView) findViewById(R.id.next);
       previous=(TextView)findViewById(R.id.previous);
       Education=findViewById(R.id.education);
       CompanyName=findViewById(R.id.CompanyName);
       demo=findViewById(R.id.demo);
       Designation=findViewById(R.id.designation);
       WorkNature=findViewById(R.id.worknature);
       BLocation=findViewById(R.id.busiloc);
       occupationfeild();
       buttonsclick(bundle);

    }

    private void buttonsclick(Bundle bundle) {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 education=Education.getText().toString();
                 companyname=CompanyName.getText().toString();
                 designation=Designation.getText().toString();
                 worknature=WorkNature.getText().toString();
                 busiloc=BLocation.getText().toString();
                 SharedPreferences sp=getSharedPreferences("DetailsKey",MODE_PRIVATE);
                 SharedPreferences.Editor ed=sp.edit();
                ed.putString("Education",education);
                ed.putString("CompanyName",companyname);
              //  ed.putString("Occupation",occupation);
                ed.putString("Designation",designation);
                ed.putString("WorkNature",worknature);
                ed.putString("KeyNature",busiloc);
                Intent intent=new Intent(getApplicationContext(),need_require.class);;
                startActivity(intent);
                finish();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),personal.class));
                finish();
            }
        });
    }

    private void occupationfeild() {
        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(),R.layout.occupation_item,occupations);
       arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        occupation.setAdapter(arrayAdapter);
        occupation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}