package com.tahir.transferwise_task_1.Database;


import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.tahir.transferwise_task_1.Models.Articles;

import java.util.List;

public class DbRepository {
    static DbRepository dbr = null;
    ArticlesDao articleDao;
    LiveData<List<Articles>> ListShoppingItems;


    public DbRepository(Context application) {
        AppDB db = DbObject.getInstance(application);
        articleDao = db.articleDao();

    }



    public LiveData<List<Articles>> getAllShoppingItems() {
        return articleDao.getallItems();

    }


    public void setListOfReceicve() {
        ListShoppingItems = articleDao.getallItems();


    }

    public void insertItems(Articles sms) {
        new insertAsyncTask(articleDao).execute(sms);
    }

    private static class insertAsyncTask extends AsyncTask<Articles, Void, Void> {

        private ArticlesDao mAsyncTaskDao;

        insertAsyncTask(ArticlesDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Articles... params) {
            mAsyncTaskDao.insertItem(params[0]);
            return null;
        }
    }
}
