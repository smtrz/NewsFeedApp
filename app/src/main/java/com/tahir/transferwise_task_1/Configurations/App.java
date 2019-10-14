package com.tahir.transferwise_task_1.Configurations;

import android.app.Application;

import com.tahir.transferwise_task_1.Components.AppLevelComponent;
import com.tahir.transferwise_task_1.Components.DaggerAppLevelComponent;
import com.tahir.transferwise_task_1.Modules.ContextModule;
import com.tahir.transferwise_task_1.Modules.DbRepoModule;
import com.tahir.transferwise_task_1.Modules.NetModule;


public class App extends Application {
    public static App app;
    public AppLevelComponent appComponent;


    public static App getApp() {
        return app;
    }


    public AppLevelComponent getAppLevelComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
// we only have to set constructor modules or context modules.
        appComponent = DaggerAppLevelComponent.builder()
                .contextModule(new ContextModule(this))
                .dbRepoModule(new DbRepoModule())
                .netModule(new NetModule("https://newsapi.org/v2/"))


                .build();


    }


}
