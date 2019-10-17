package com.tahir.newsfeedapp.Models;


import java.util.List;

public class News
{
    private String totalResults;

    private List<Articles> articles;

    private String status;

    public String getTotalResults ()
    {
        return totalResults;
    }

    public void setTotalResults (String totalResults)
    {
        this.totalResults = totalResults;
    }

    public List<Articles> getArticles ()
    {
        return articles;
    }

    public void setArticles (List<Articles> articles)
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
