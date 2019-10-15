package com.tahir.transferwise_task_1.Modules;

import android.content.Context;

import com.tahir.transferwise_task_1.Database.AppDB;
import com.tahir.transferwise_task_1.Database.DbRepository;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;


@Module


public class DbRepoModule {


    @Provides
    @Singleton
    public DbRepository getRepository(Context c) {

        return new DbRepository(c);

    }

    @Provides
    @Singleton
    public AppDB getAppDb(Context c) {
        return Room.databaseBuilder(c, AppDB.class, "userdb").build();
//        ;

    }

}