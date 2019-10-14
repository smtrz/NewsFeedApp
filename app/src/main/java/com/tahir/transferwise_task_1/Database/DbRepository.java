package com.tahir.transferwise_task_1.Database;


import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tahir.transferwise_task_1.Configurations.App;
import com.tahir.transferwise_task_1.Models.Articles;
import com.tahir.transferwise_task_1.Models.News;
import com.tahir.transferwise_task_1.Networking.EndpointsInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DbRepository {

    ArticlesDao articleDao;
    // LiveData<List<Articles>> article_lists;
    //Context c;
    @Inject
    Retrofit retrofit;
    MutableLiveData<Boolean> dataLoading = new MutableLiveData<>();


    DbRepository() {


    }

    public DbRepository(Context application) {


        AppDB db = DbObject.getInstance(application);
        articleDao = db.articleDao();
        App.getApp().getAppLevelComponent().inject(DbRepository.this);
        // this.c = application;
    }


    public LiveData<List<Articles>> getallArticles() {
        return articleDao.getallItems();

    }


    public void deleteAllitems() {
        new deleteAsync(articleDao).execute();

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

    private static class deleteAsync extends AsyncTask<Void, Void, Void> {

        private ArticlesDao mAsyncTaskDao;

        deleteAsync(ArticlesDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... params) {
            mAsyncTaskDao.delete();
            //mAsyncTaskDao.insertItem(params[0]);
            return null;
        }
    }

    // network call to get all the news
    public void getAllNews() {
        dataLoading.setValue(true);
        //   ProgressDialog sd = ProgressDialogHelper.showDialog(c);
        EndpointsInterface endpoints = retrofit.create(EndpointsInterface.class);
        endpoints.getNewsList("us", "c10e794e2bfd4a778276f1480041ba73").enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                dataLoading.setValue(false);
                //   ProgressDialogHelper.cancelDialog(sd);
                if (response.isSuccessful()) {
                    // successful call
                    //    Mutualable_article_lists.setValue(response.body().getArticles());
                    deleteAllitems();
                    insertItems(response.body().getArticles());
                } else {
                    // log the error and show the data from db
                    // article_lists = getAllNews();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                dataLoading.setValue(false);
                // log the error and show the data from db
                // ProgressDialogHelper.cancelDialog(sd);
            }
        });
        // return article_lists;
    }

    public MutableLiveData ifDataIsloading() {
        return dataLoading;

    }
}
