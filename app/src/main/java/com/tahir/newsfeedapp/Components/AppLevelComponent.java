package com.tahir.newsfeedapp.Components;

import com.tahir.newsfeedapp.Database.DbRepository;
import com.tahir.newsfeedapp.Modules.ContextModule;
import com.tahir.newsfeedapp.Modules.DbRepoModule;
import com.tahir.newsfeedapp.Modules.NetModule;
import com.tahir.newsfeedapp.ViewModels.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ContextModule.class, DbRepoModule.class, NetModule.class})
@Singleton
public interface AppLevelComponent {

    void inject(MainActivityViewModel ma);

    void inject(DbRepository dr);


}
