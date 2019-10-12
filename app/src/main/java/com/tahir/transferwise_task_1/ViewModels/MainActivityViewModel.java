package com.tahir.transferwise_task_1.ViewModels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tahir.transferwise_task_1.Database.DbRepository;
import com.tahir.transferwise_task_1.Models.Articles;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

  //  MutableLiveData<List<Articles>> article_list;

    //@Inject
    DbRepository dbrepo;


    public void init(Context c){

        dbrepo = new DbRepository(c);
        dbrepo.getAllNews();

    }

    MutableLiveData<List<Articles>> getAllItems() {
        return dbrepo.getAllShoppingItems();

    }


}


