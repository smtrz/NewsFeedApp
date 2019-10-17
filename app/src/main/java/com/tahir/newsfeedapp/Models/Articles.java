package com.tahir.newsfeedapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "articles")

public class Articles implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;
    private String publishedAt;

    private String author;

    private String urlToImage;

    private String description;

   // private Source source;

    private String title;

    private String url;

    private String content;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.publishedAt);
        dest.writeString(this.author);
        dest.writeString(this.urlToImage);
        dest.writeString(this.description);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.content);
    }

    public Articles() {
    }

    protected Articles(Parcel in) {
        this.id = in.readInt();
        this.publishedAt = in.readString();
        this.author = in.readString();
        this.urlToImage = in.readString();
        this.description = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.content = in.readString();
    }

    public static final Parcelable.Creator<Articles> CREATOR = new Parcelable.Creator<Articles>() {
        @Override
        public Articles createFromParcel(Parcel source) {
            return new Articles(source);
        }

        @Override
        public Articles[] newArray(int size) {
            return new Articles[size];
        }
    };
}

