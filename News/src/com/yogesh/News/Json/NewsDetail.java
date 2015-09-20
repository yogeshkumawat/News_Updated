package com.yogesh.News.Json;

public class NewsDetail
{
    private Item Item;

    public Item getItem ()
    {
        return Item;
    }

    public void setItem (Item Item)
    {
        this.Item = Item;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Item = "+Item+"]";
    }
}
