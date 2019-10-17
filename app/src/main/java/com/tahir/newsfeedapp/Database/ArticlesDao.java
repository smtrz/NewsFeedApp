package com.tahir.newsfeedapp.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tahir.newsfeedapp.Models.Articles;

import java.util.List;

@Dao
public interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(List<Articles> items);

    @Query("SELECT * from articles")
    LiveData<List<Articles>> getallItems();

    @Query("DELETE FROM articles")
    void delete();
}

