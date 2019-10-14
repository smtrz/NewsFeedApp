package com.tahir.transferwise_task_1.Modules;

import com.tahir.transferwise_task_1.Helpers.DateHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DateModule {
    @Provides
    @Singleton
    static Date getDate() {

        return new Date();
    }

    @Provides
    @Singleton

    static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    }

    @Provides
    @Singleton

    static DateHelper getDateHelper() {
        return new DateHelper();

    }
}
