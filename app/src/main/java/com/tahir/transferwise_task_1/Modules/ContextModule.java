package com.tahir.transferwise_task_1.Modules;

import android.content.Context;


import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context c;

    public ContextModule(Context c) {
        this.c = c;
    }


    @Provides
    public Context provideContext() {

        return c;
    }
}
