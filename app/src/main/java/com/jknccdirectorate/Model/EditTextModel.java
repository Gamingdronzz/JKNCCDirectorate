package com.jknccdirectorate.Model;

/**
 * Created by hp on 11-09-2017.
 */

public class EditTextModel {
    private String title;
    private int icon;

    public EditTextModel(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public int getIcon() {

        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public EditTextModel(String title) {
        this.title = title;
       }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

  }
