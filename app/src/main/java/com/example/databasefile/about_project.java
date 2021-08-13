package com.example.databasefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class about_project extends AppCompatActivity {
TextView pleasure,aboutproject,printadv,demo;
CheckBox news1,news2,news3,news4;
String news_1,news_2,news_3,news_4;
TextInputEditText newspaper,hording,digital,telecalling,source,refer,partner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_project);
        pleasure=findViewById(R.id.pleasuretxt);
        aboutproject=findViewById(R.id.aboutproject);
        printadv=findViewById(R.id.printadv);
        news1=findViewById(R.id.news1);
        news2=findViewById(R.id.news2);
        news3=findViewById(R.id.news3);
        news4=findViewById(R.id.news4);
        newspaper=findViewById(R.id.newsinsert);
        hording=findViewById(R.id.hording);
        digital=findViewById(R.id.digital);
        telecalling=findViewById(R.id.telecalling);
        source=findViewById(R.id.source);
        refer=findViewById(R.id.refer);
        partner=findViewById(R.id.partner);
        printadvertisment();
        submitbut();
    }


    //Print Advertisment
    private void printadvertisment() {
        news1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news1.isChecked()){
                    news_1="Times Of India";
                    Toast.makeText(getApplicationContext(),"one",Toast.LENGTH_LONG).show();
                }
            }
        });
        news2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news2.isChecked()){
                    news_2="Hindusatan Times";
                    Toast.makeText(getApplicationContext(),"two",Toast.LENGTH_LONG).show();
                }
            }
        });
        news3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news3.isChecked()){
                    news_3="Mid-Day";
                    Toast.makeText(getApplicationContext(),"Three",Toast.LENGTH_LONG).show();
                }
            }
        });
        news4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (news4.isChecked()){
                    news_4="Mumbai Mirror";
                    Toast.makeText(getApplicationContext(),"Three",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //Submit Button
    private void submitbut() {
        SharedPreferences sp=getSharedPreferences("DetailsKey",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();

    }
}