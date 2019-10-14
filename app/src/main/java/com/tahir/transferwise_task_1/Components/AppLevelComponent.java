package com.tahir.transferwise_task_1.Components;

import android.content.Context;

import com.tahir.transferwise_task_1.Database.DbRepository;
import com.tahir.transferwise_task_1.Modules.ContextModule;
import com.tahir.transferwise_task_1.Modules.DbRepoModule;
import com.tahir.transferwise_task_1.Modules.NetModule;
import com.tahir.transferwise_task_1.ViewModels.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

/*
package com.tahir.transferwise_task_1.Components;

import android.content.Context;

import com.tahir.transferwise_task_1.Database.DbRepository;
import com.tahir.transferwise_task_1.Modules.ContextModule;
import com.tahir.transferwise_task_1.Modules.DateModule;
import com.tahir.transferwise_task_1.Modules.DbRepoModule;
import com.tahir.transferwise_task_1.ViewModels.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, DbRepoModule.class})

public interface AppLevelComponent {

    Context getContext();

    DbRepository getrepo();

    void inject(MainActivityViewModel mvm);

}
*/
@Component(modules = {ContextModule.class, DbRepoModule.class,NetModule.class})
@Singleton
public interface AppLevelComponent {

    void inject(MainActivityViewModel ma);
    void inject(DbRepository dr);

  //  void inject(DbRepository dr);

}
