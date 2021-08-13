package com.example.databasefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import static android.content.ContentValues.TAG;

public class need_require extends AppCompatActivity {
    Spinner budget;
    TextView next, previous,demo,Configuration,HomeLoan,Purchase,Residantial,specify;
    TextInputEditText BankName;
    CheckBox one,two,three,other,selfuse,investment,secondhome;
    RadioGroup loangroup,typegroup;
    String budgets[] = {"< 1Cr.", "1.0 - 1.25 Cr", "1.25 – 1.5 Cr", "1.5 – 2 Cr", "2 cr & above"};
    String loangroupval,typegroupval,selfuses,investments,SecondHomes,ones,twos,threes,others,specifys;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.need_require);
        Bundle bundle=getIntent().getExtras();
        budget = findViewById(R.id.spinner);
        next=findViewById(R.id.next);
        previous=findViewById(R.id.previous);
        Configuration=findViewById(R.id.configration);
        HomeLoan=findViewById(R.id.loan);
        Purchase=findViewById(R.id.purchase);
        Residantial=findViewById(R.id.residental);
        BankName=findViewById(R.id.bankname);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        other=findViewById(R.id.other);
        specify=findViewById(R.id.specify);
        selfuse=findViewById(R.id.selfuse);
        investment=findViewById(R.id.investment);
        secondhome=findViewById(R.id.secondhome);
        loangroup=findViewById(R.id.loangroup);
        typegroup=findViewById(R.id.typegroup);
        demo=findViewById(R.id.demo);
        buttonclick(bundle);
        budgetitem();
        loangrouptxt();
        typegrouptxt();
        configurationbox();
        purcharsebox();
    }
//Nature Of Purchase
    private void purcharsebox() {
        selfuse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (selfuse.isChecked()){
                    selfuses="Self-Use";
                    Toast.makeText(getApplicationContext(),"one",Toast.LENGTH_LONG).show();
                }
            }
        });
        investment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (investment.isChecked()){
                    investments="Investment";
                    Toast.makeText(getApplicationContext(),"two",Toast.LENGTH_LONG).show();
                }
            }
        });
        secondhome.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (secondhome.isChecked()){
                    SecondHomes="Second Home";
                    Toast.makeText(getApplicationContext(),"Three",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
//Configuration
    private void configurationbox() {
       one.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (one.isChecked()){
                   ones="1 BHK";
               }
           }
       });
        two.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (two.isChecked()){
                    twos="2 BHK";
                }
            }
        });
        three.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (three.isChecked()){
                    threes="2 BHK";
                }
            }
        });
        other.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (other.isChecked()){
                    others="other";
                    specifys=specify.getText().toString();
                }
            }
        });
    }
//Current Residental Type
    private void typegrouptxt() {
        typegroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.owned == checkedId){
                    typegroupval ="Owned";
                }
                else if (R.id.rent == checkedId){
                    typegroupval="Rented";
                }
                else{
                    typegroupval="null";
                }
            }
        });
    }

//Home Loan
    private void loangrouptxt() {
        loangroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.approve == checkedId){
                   loangroupval ="Approve";
                }
                else if (R.id.noapprove == checkedId){
                    loangroupval="No Approve";
                }
                else{
                   loangroupval="null";
                }
            }
        });
    }
//Next Previous
    private void buttonclick(Bundle bundle) {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp=getSharedPreferences("DetailsKey",MODE_PRIVATE);
                SharedPreferences.Editor ed=sp.edit();
                ed.putString("ONE",ones);
                ed.putString("TWO",twos);
                ed.putString("THREE",threes);
                ed.putString("OTHER",others);
                ed.putString("SPECIFY",specifys);
                ed.putString("Loan",loangroupval);
                ed.putString("BankName",BankName.getText().toString());
                ed.putString("SelfUses",selfuses);
                ed.putString("Investments",investments);
                ed.putString("Secondhome",SecondHomes);
                ed.putString("Residantal",typegroupval);

                Intent intent=new Intent(getApplicationContext(),about_project.class);
                startActivity(intent);
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
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        budget.setAdapter(arrayAdapter);
       budget.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });


    }
}