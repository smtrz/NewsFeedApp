package com.tahir.transferwise_task_1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.tahir.transferwise_task_1.Components.DaggerAppLevelComponent;
import com.tahir.transferwise_task_1.Helpers.DateHelper;
import com.tahir.transferwise_task_1.Helpers.GeneralHelper;
import com.tahir.transferwise_task_1.Interfaces.NewsListInterface;
import com.tahir.transferwise_task_1.Models.Articles;
import com.tahir.transferwise_task_1.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> implements RecyclerView.OnClickListener {

    Context context;
    List<Articles> articles;
    @BindView(R.id.share)
    ImageView share;
    @Inject
    DateHelper dh;

    public NewsAdapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
        DaggerAppLevelComponent.create().inject(this);

    }

    public void loadItems(List<Articles> newItems, NewsListInterface ni) {

        articles = newItems;
        ni.ifListisEmpty(articles.size());
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newlist_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        try {
            holder.newsTitle.setText(articles.get(position).getTitle());
            holder.published.setText(dh.calculateDateDifference(articles.get(position).getPublishedAt()));
            holder.newsInfo.setText(articles.get(position).getDescription());
            holder.author.setText(articles.get(position).getAuthor());

            Picasso.get().load(articles.get(position).getUrlToImage()).into(holder.thumbnail);


            holder.share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GeneralHelper.shareNews(articles.get(position).getTitle(), articles.get(position).getUrl(), context);
                }
            });
        } catch (Exception e) {
//eat this one.

        }
    }

    @Override
    public int getItemCount() {
        if (articles != null) {

            return articles.size();
        } else {

            return 0;
        }

    }

    @Override
    public void onClick(View v) {

    }


    public class NewsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.share)
        TextView share;
        @BindView(R.id.published_date)
        TextView publishedDate;
        @BindView(R.id.newsTitle)
        TextView newsTitle;
        @BindView(R.id.newsInfo)
        TextView newsInfo;
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.published)
        TextView published;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }


}