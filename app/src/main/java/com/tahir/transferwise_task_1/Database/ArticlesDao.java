package com.tahir.transferwise_task_1.Database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.tahir.transferwise_task_1.Models.Articles;

import java.util.List;

@Dao
public interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(List<Articles> items);

    @Query("SELECT * from articles")
    MutableLiveData<List<Articles>> getallItems();
}

