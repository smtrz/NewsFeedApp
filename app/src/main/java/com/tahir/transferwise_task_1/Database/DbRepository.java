package com.tahir.transferwise_task_1.Database;


import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tahir.transferwise_task_1.Models.Articles;
import com.tahir.transferwise_task_1.Models.News;
import com.tahir.transferwise_task_1.Networking.EndpointsInterface;
import com.tahir.transferwise_task_1.Networking.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DbRepository {
    static DbRepository dbr = null;
    ArticlesDao articleDao;
    MutableLiveData<List<Articles>> article_lists;


    public DbRepository(Context application) {
        AppDB db = DbObject.getInstance(application);
        articleDao = db.articleDao();

    }

    public static DbRepository getInstance(Context c){
        if (dbr == null){
            dbr = new DbRepository(c);
        }
        return dbr;
    }


    public MutableLiveData<List<Articles>> getAllShoppingItems() {
        return articleDao.getallItems();

    }


    public void setListOfReceicve() {
        article_lists = articleDao.getallItems();


    }

    public void insertItems(List<Articles> sms) {
        new insertAsyncTask(articleDao).execute(sms);
    }

    private static class insertAsyncTask extends AsyncTask<List<Articles>, Void, Void> {

        private ArticlesDao mAsyncTaskDao;

        insertAsyncTask(ArticlesDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Articles>... params) {
            mAsyncTaskDao.insertItem(params[0]);
            return null;
        }
    }

    // network call to get all the news
    public void getAllNews() {
        EndpointsInterface endpoints = RetrofitClient.getRetrofitInstance().create(EndpointsInterface.class);
        endpoints.getNewsList("us", "c10e794e2bfd4a778276f1480041ba73").enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful()) {
                    // successful call
                    article_lists.setValue(response.body().getArticles());
                    insertItems(response.body().getArticles());
                } else {
                    // log the error and show the data from db
                   // article_lists = getAllNews();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                // log the error and show the data from db
            }
        });
       // return article_lists;
    }
}
