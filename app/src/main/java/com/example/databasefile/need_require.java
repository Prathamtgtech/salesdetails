package com.example.databasefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class need_require extends AppCompatActivity {
    AutoCompleteTextView budget;
    TextView next, previous;
    String budgets[] = {"< 1Cr.", "1.0 - 1.25 Cr", "1.25 – 1.5 Cr", "1.5 – 2 Cr", "2 cr & above"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.need_require);
        budget = findViewById(R.id.budget);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        buttonclick();
        budgetitem();
    }

    private void buttonclick() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),about_project.class));
                finish();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),personal_2.class));
                finish();
            }
        });
    }

    private void budgetitem() {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.budget_item, budgets);
        budget.setText(arrayAdapter.getItem(0).toString(), false);
        budget.setAdapter(arrayAdapter);
    }
}