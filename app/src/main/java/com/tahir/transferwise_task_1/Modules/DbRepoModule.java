package com.tahir.transferwise_task_1.Modules;

import android.content.Context;

import com.tahir.transferwise_task_1.Database.DbRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
        (includes = ContextModule.class)

public class DbRepoModule {


    @Provides
    @Singleton
    public DbRepository getRepository(Context c) {

        return new DbRepository(c);

    }
}