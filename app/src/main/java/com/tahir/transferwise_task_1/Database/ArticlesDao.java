package com.tahir.transferwise_task_1.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.tahir.transferwise_task_1.Models.Articles;

import java.util.List;

@Dao
public interface ArticlesDao {
    @Insert
    void insertItem(Articles item);

    @Query("SELECT * from articles")
    LiveData<List<Articles>> getallItems();
}

