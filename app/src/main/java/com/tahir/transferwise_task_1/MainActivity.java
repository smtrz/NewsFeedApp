package com.tahir.transferwise_task_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.tahir.transferwise_task_1.Activities.BaseActivity;
import com.tahir.transferwise_task_1.Activities.News_Detail_Activity;
import com.tahir.transferwise_task_1.Adapters.NewsAdapter;
import com.tahir.transferwise_task_1.Helpers.ProgressDialogHelper;
import com.tahir.transferwise_task_1.Helpers.RecyclerItemClickListener;
import com.tahir.transferwise_task_1.Helpers.UIHelper;
import com.tahir.transferwise_task_1.Interfaces.NewsListInterface;
import com.tahir.transferwise_task_1.Models.Articles;
import com.tahir.transferwise_task_1.ViewModels.MainActivityViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NewsListInterface {

    MainActivityViewModel newsViewModel;
    @BindView(R.id.rvNews)
    RecyclerView rvNews;
    NewsAdapter adapter;
    List<Articles> list;
    @BindView(R.id.empty_view)
    TextView emptyView;
    ProgressDialog sd = null;
    @BindView(R.id.pullToRefresh)
    SwipeRefreshLayout pullToRefresh;
    List<Articles> a;
    @BindView(R.id.parent)
    ConstraintLayout parent_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

        newsViewModel.getAllItems().observe(this, new Observer<List<Articles>>() {
            @Override
            public void onChanged(@Nullable List<Articles> articles) {
                a = articles;
                adapter.loadItems(articles, MainActivity.this::ifListisEmpty);
                adapter.notifyDataSetChanged();

            }
        });
        newsViewModel.ifDataIsloading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                if (aBoolean) {
                    sd = ProgressDialogHelper.showDialog(MainActivity.this);

                } else {
                    if (sd != null) {
                        ProgressDialogHelper.cancelDialog(sd);
                    }
                }


            }
        });

        rvNews.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                try {
                    Intent i = new Intent(MainActivity.this, News_Detail_Activity.class);
                    i.putExtra("news", a.get(position));
                    startActivity(i);
                } catch (Exception e) {

                    UIHelper.showSnackToast(parent_layout, "Unable to load the selected news article.");
                }
            }
        }));

    }

    public void init() {
        newsViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAdapter(this, list);
        rvNews.setAdapter(adapter);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsViewModel.callNewsAPI();
                pullToRefresh.setRefreshing(false);
            }
        });

    }


    @Override
    public void ifListisEmpty(int count) {
        if (adapter.getItemCount() == 0) {
            rvNews.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            rvNews.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }


}

