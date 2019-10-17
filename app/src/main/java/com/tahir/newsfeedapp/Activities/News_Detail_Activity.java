package com.tahir.newsfeedapp.Activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tahir.newsfeedapp.Components.DaggerDateComponent;
import com.tahir.newsfeedapp.Helpers.DateHelper;
import com.tahir.newsfeedapp.Models.Articles;
import com.tahir.newsfeedapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class News_Detail_Activity extends BaseActivity {


    @BindView(R.id.thumbnail)
    ImageView thumbnail;
    @BindView(R.id.newsTitle)
    TextView newsTitle;
    @BindView(R.id.newsInfo)
    TextView newsInfo;
    @BindView(R.id.published)
    TextView published;
    @BindView(R.id.content)
    TextView content;
    @Inject
    DateHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailview_news);
        ButterKnife.bind(this);
        init();

    }

    public void init() {
        DaggerDateComponent.create().inject(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle data = getIntent().getExtras();
        Articles article = (Articles) data.getParcelable("news");
        Picasso.get().load(article.getUrlToImage()).into(thumbnail);
        published.setText(dh.calculateDateDifference(article.getPublishedAt()) + "  |  " + article.getAuthor());
        newsTitle.setText(article.getTitle());
        newsInfo.setText(article.getDescription());
        String content_data =null;
        if(article.getContent()!=null){

            content_data = article.getContent().split("\\[")[0] + "\n" + "\nMore at: \n" + article.getUrl();
        }
        else{

            content_data= "Read more about it from : \n"+article.getUrl();
        }
        content.setText(content_data);
    }



}
