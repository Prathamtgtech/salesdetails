package com.example.databasefile.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CustomerDetails {
    @PrimaryKey(autoGenerate = true)
    int id;
String name;
String locality;
String city;
int pincode;
int time;
int phoneno;
int altphone;
String education;
String occupation;


}
