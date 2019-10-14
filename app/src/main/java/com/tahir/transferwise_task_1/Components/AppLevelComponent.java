package com.tahir.transferwise_task_1.Components;

import android.content.Context;

import com.tahir.transferwise_task_1.Activities.News_Detail_Activity;
import com.tahir.transferwise_task_1.Adapters.NewsAdapter;
import com.tahir.transferwise_task_1.Database.DbRepository;
import com.tahir.transferwise_task_1.Helpers.DateHelper;
import com.tahir.transferwise_task_1.Modules.ContextModule;
import com.tahir.transferwise_task_1.Modules.DateModule;
import com.tahir.transferwise_task_1.Modules.DbRepoModule;
import com.tahir.transferwise_task_1.ViewModels.MainActivityViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {DateModule.class})

public interface AppLevelComponent {


    Date getdate();

    SimpleDateFormat getdateformat();

    void inject(DateHelper dh);

    void inject(NewsAdapter dh);

    void inject(News_Detail_Activity dh);

    //Context getContext();

    //DbRepository getrepo();

  //  void inject(MainActivityViewModel mvm);
}
