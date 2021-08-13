package com.example.databasefile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.databasefile.Database.CustomerDetails;
import com.example.databasefile.Database.DAO;
import com.example.databasefile.Database.MyDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class personal extends AppCompatActivity {
    TextInputEditText Timer, Name, Locality, City, Pincode, Phone, AltPhone, Email;
    TimePickerDialog timePickerDialog;
    Button next;
    Calendar calendar;
    int currentHour;
    int currentMin;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    String ampm;
    String name,locality,city,pincode,timers,phoneno,altphoneno,emailid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);
        Timer = findViewById(R.id.Timer);
        Name = findViewById(R.id.Name);
        Locality = findViewById(R.id.Locality);
        City = findViewById(R.id.City);
        Pincode = findViewById(R.id.Pincode);
        Phone = findViewById(R.id.Phone);
        AltPhone = findViewById(R.id.AltPhone);
        Email = findViewById(R.id.Emailid);
        next=(Button)findViewById(R.id.Next);
        //Timer
        TimpePicker();
        //nextbut
        nextbut();

        //string values
        userPersonalDetails();
    }


    //User Details
    private void userPersonalDetails() {

    }


    //Next Activity
    private void nextbut() {
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {



                    //pass values
            name=Name.getText().toString();
            locality=Locality.getText().toString();
            city=City.getText().toString();
            pincode=Pincode.getText().toString();
            timers=Timer.getText().toString();
            phoneno=Phone.getText().toString();
            altphoneno=AltPhone.getText().toString();
            emailid=Email.getText().toString();
            //Share Prefrence
            sp=getSharedPreferences("DetailsKey",MODE_PRIVATE);
            ed=sp.edit();
            ed.putString("Name",name);
            ed.putString("Locality",locality);
            ed.putString("City",city);
            ed.putString("Pincode",pincode);
            ed.putString("Timer",timers);
            ed.putString("Phone",phoneno);
            ed.putString("AltPhone",altphoneno);
            ed.putString("Email",emailid);
            ed.apply();
            Intent intent=new Intent(getApplicationContext(),personal_2.class);
            startActivity(intent);
        }
    });

    }



    //TimePicker
        private void TimpePicker () {

            Timer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calendar = Calendar.getInstance();
                    currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                    currentMin = calendar.get(Calendar.MINUTE);
                    timePickerDialog = new TimePickerDialog(personal.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            if (hourOfDay >= 12) {
                                ampm = "PM";
                            } else {
                                ampm = "AM";
                            }
                            Timer.setText(String.format("%02d:%02d", hourOfDay, minute) + ampm);
                        }
                    }, currentHour, currentMin, false);
                    timePickerDialog.show();
                }
            });
        }
    }