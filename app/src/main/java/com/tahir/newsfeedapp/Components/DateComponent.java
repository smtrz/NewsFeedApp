package com.tahir.newsfeedapp.Components;

import com.tahir.newsfeedapp.Activities.News_Detail_Activity;
import com.tahir.newsfeedapp.Adapters.NewsAdapter;
import com.tahir.newsfeedapp.Helpers.DateHelper;
import com.tahir.newsfeedapp.Modules.DateModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DateModule.class})

public interface DateComponent {

    void inject(DateHelper dh);

    void inject(NewsAdapter dh);

    void inject(News_Detail_Activity dh);




}
