package com.yogesh.News.Json;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class News {

@Expose
private List<NewsItem> NewsItem = new ArrayList<NewsItem>();

/**
*
* @return
* The Pagination
*/

/**
*
* @param Pagination
* The Pagination
*/

/**
*
* @return
* The NewsItem
*/
public List<NewsItem> getNewsItem() {
return NewsItem;
}

/**
*
* @param NewsItem
* The NewsItem
*/
public void setNewsItem(List<NewsItem> NewsItem) {
this.NewsItem = NewsItem;
}

}