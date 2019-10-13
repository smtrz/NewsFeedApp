package com.tahir.transferwise_task_1.ViewModels;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tahir.transferwise_task_1.Database.DbRepository;
import com.tahir.transferwise_task_1.Models.Articles;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    //  MutableLiveData<List<Articles>> article_list;

    //@Inject
    DbRepository dbrepo;

    public MainActivityViewModel(Application application) {
        super(application);
        dbrepo = new DbRepository(application);
        dbrepo.getAllNews();
        //  App.getApp().getAppLevelComponent().inject(this);
        //  dbrepo = DbRepository.getInstance(application);

    }


    public LiveData<List<Articles>> getAllItems() {
        return dbrepo.getallArticles();

    }
    public MutableLiveData<Boolean> ifDataIsloading() {
        return dbrepo.ifDataIsloading();

    }
// just refresh the data based on the result.

   public void callNewsAPI(){
       dbrepo.getAllNews();

   }

}


