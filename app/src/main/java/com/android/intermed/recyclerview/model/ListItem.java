package com.android.intermed.recyclerview.model;


public class ListItem {

    private String title;
    private int image;
    private boolean favourite = false;

    public String getTitle()
    {
        return title;
    }

    public void  setTitle(String title)
    {
        this.title = title;
    }

    public boolean isFavourite() { return favourite; }

    public void setFavourite(boolean favourite)
    {
        this.favourite = favourite;
    }

    public int getImage()
    {
        return image;
    }

    public void  setImage(int image)
    {
        this.image = image;
    }

}
