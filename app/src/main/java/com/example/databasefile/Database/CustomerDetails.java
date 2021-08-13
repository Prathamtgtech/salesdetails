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
String emailid;

//constructor


    public CustomerDetails() {
        this.id = id;
        this.name = name;
        this.locality = locality;
        this.city = city;
        this.pincode = pincode;
        this.time = time;
        this.phoneno = phoneno;
        this.altphone = altphone;
        this.emailid = emailid;
    }

    //getter and setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public int getAltphone() {
        return altphone;
    }

    public void setAltphone(int altphone) {
        this.altphone = altphone;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
}
