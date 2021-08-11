package com.example.databasefile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class personal extends AppCompatActivity {
    TextInputEditText Timer, Name, Locality, City, Pincode, Phone, AltPhone, Email;
    TimePickerDialog timePickerDialog;
    Button next;
    Calendar calendar;
    int currentHour;
    int currentMin;
    String ampm;


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
        //GetValueFromUser
        getValuerFromUser();
        //nextbut
        nextbut();

    }
//Next Activity
    private void nextbut() {
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent details=new Intent(getApplicationContext(),personal_2.class);
            startActivity(details);
            finishActivity(1);
        }
    });

    }


    //User InputFeild
        private void getValuerFromUser(){
//            String name = Name.getText().toString();
//            String locality = Locality.getText().toString();
//            String city = City.getText().toString();
//            String pincode = Pincode.getText().toString();
//            int phone = Integer.parseInt(Phone.getText().toString());
//            int altphone = Integer.parseInt(AltPhone.getText().toString());
//            String emailid= Email.getText().toString();
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