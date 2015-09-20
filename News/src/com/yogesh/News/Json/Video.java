package com.yogesh.News.Json;

import com.google.gson.annotations.Expose;

public class Video {

@Expose
private String Thumb;
@Expose
private String VideoCaption;
@Expose
private String DetailFeed;
@Expose
private String Type;

/**
*
* @return
* The Thumb
*/
public String getThumb() {
return Thumb;
}

/**
*
* @param Thumb
* The Thumb
*/
public void setThumb(String Thumb) {
this.Thumb = Thumb;
}

/**
*
* @return
* The VideoCaption
*/
public String getVideoCaption() {
return VideoCaption;
}

/**
*
* @param VideoCaption
* The VideoCaption
*/
public void setVideoCaption(String VideoCaption) {
this.VideoCaption = VideoCaption;
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