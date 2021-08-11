package com.example.databasefile.Database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface DAO {

@Insert
    void InsertCustomerDetails(CustomerDetails customerDetails);
}
