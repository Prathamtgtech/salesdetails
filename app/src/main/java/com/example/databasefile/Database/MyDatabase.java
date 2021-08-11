package com.example.databasefile.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = CustomerDetails.class,version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DAO Dao();
}
