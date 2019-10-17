package com.tahir.newsfeedapp.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tahir.newsfeedapp.Configurations.App;
import com.tahir.newsfeedapp.Database.DbRepository;
import com.tahir.newsfeedapp.Models.Articles;

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


