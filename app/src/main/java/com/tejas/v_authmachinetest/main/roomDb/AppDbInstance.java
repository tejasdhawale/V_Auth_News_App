package com.tejas.v_authmachinetest.main.roomDb;

import android.content.Context;

import androidx.room.Room;

public class AppDbInstance {
    public static AppDatabase database = null;

    public static AppDatabase getAppDbInstance(Context context) {
        if (database == null)
            database = Room.databaseBuilder(context, AppDatabase.class, "db-articles")
                    .allowMainThreadQueries()   //Allows room to do operation on main thread
                    .build();

        return database;

    }
}
