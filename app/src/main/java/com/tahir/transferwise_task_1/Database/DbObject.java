package com.tahir.transferwise_task_1.Database;


import android.content.Context;

import androidx.room.Room;

public class DbObject {
    private static AppDB ourInstance = null;

    private DbObject() {
    }

    public static AppDB getInstance(Context c) {
        if (ourInstance == null) {

            ourInstance = Room.databaseBuilder(c, AppDB.class, "userdb").build();

        }


        return ourInstance;
    }
}
