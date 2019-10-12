package com.tahir.transferwise_task_1.Models;


public class News
{
    private String totalResults;

    private Articles[] articles;

    private String status;

    public String getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (String totalResults)
    {
        this.totalResults = totalResults;
    }

    public Articles[] getArticles ()
    {
        return articles;
    }

    public void setArticles (Articles[] articles)
    {
        this.articles = articles;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }


}
