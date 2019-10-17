package com.tahir.newsfeedapp.Database;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tahir.newsfeedapp.Models.Articles;

@Database(entities = {Articles.class}, version = 1,exportSchema = false)
public abstract class AppDB extends RoomDatabase {


    public abstract ArticlesDao articleDao();
}
