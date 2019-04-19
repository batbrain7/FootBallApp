package com.example.mohitkumar.footballapp.data;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public abstract class AppDatabase extends RoomDatabase {

    public abstract FootBallDao footBallDao();

    public static AppDatabase getAppDataBase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "football-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
