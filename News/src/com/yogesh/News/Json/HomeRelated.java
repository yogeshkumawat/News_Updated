package com.yogesh.News.Json;

import com.google.gson.annotations.Expose;

public class HomeRelated {

@Expose
private String NewsItemId;
@Expose
private String HeadLine;
@Expose
private String DetailFeed;
@Expose
private String Type;

/**
*
* @return
* The NewsItemId
*/
public String getNewsItemId() {
return NewsItemId;
}

/**
*
* @param NewsItemId
* The NewsItemId
*/
public void setNewsItemId(String NewsItemId) {
this.NewsItemId = NewsItemId;
}

/**
*
* @return
* The HeadLine
*/
public String getHeadLine() {
return HeadLine;
}

/**
*
* @param HeadLine
* The HeadLine
*/
public void setHeadLine(String HeadLine) {
this.HeadLine = HeadLine;
}

/**
*
* @return
* The DetailFeed
*/
public String getDetailFeed() {
return DetailFeed;
}

/**
*
* @param DetailFeed
* The DetailFeed
*/
public void setDetailFeed(String DetailFeed) {
this.DetailFeed = DetailFeed;
}

/**
*
* @return
* The Type
*/
public String getType() {
return Type;
}

/**
*
* @param Type
* The Type
*/
public void setType(String Type) {
this.Type = Type;
}

}