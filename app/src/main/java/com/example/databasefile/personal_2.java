package com.example.databasefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class personal_2 extends AppCompatActivity {
AutoCompleteTextView occupation;
TextView next,previous;
    String occupations[]={"Salary","Business","Professional","Retired","Student"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal2);
        occupation=findViewById(R.id.occupation);
       next=(TextView) findViewById(R.id.next);
       previous=(TextView)findViewById(R.id.previous);

       occupationfeild();
       buttonsclick();

    }

    private void buttonsclick() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),need_require.class));
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
        occupation.setText(arrayAdapter.getItem(0).toString(),false);
        occupation.setAdapter(arrayAdapter);

    }

}