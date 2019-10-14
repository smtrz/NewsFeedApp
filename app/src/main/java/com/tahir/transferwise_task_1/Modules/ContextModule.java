package com.tahir.transferwise_task_1.Modules;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context c;

    public ContextModule(Context c) {
        this.c = c;
    }


    @Provides
    @Singleton
    public Context provideContext() {

        return c;
    }
}
