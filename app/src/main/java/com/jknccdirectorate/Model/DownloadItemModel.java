package com.jknccdirectorate.Model;

/**
 * Created by Balpreet on 09-Sep-17.
 */

public class DownloadItemModel {
    String title;
    String link;

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {

        return link;
    }

    public DownloadItemModel(String title, String link) {

        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DownloadItemModel(String title) {

        this.title = title;
    }
}
