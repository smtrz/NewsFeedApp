package com.tahir.transferwise_task_1.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tahir.transferwise_task_1.Configurations.App;
import com.tahir.transferwise_task_1.Database.DbRepository;
import com.tahir.transferwise_task_1.Models.Articles;

import java.util.List;

import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel {

    // injecting repository
    @Inject
    DbRepository dbrepo;

    public MainActivityViewModel(Application application) {

        super(application);
        App.getApp().getAppLevelComponent().inject(this);
    }


    public LiveData<List<Articles>> getAllItems() {
        return dbrepo.getallArticles();

    }

    public MutableLiveData<Boolean> ifDataIsloading() {
        return dbrepo.ifDataIsloading();

    }
// just refresh the data based on the result.

    public void callNewsAPI() {
        dbrepo.getAllNews();

    }

}


