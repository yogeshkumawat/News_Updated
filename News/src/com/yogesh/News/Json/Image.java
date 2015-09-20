package com.yogesh.News.Json;

import com.google.gson.annotations.Expose;

public class Image {

@Expose
private String Photo;
@Expose
private String Thumb;
@Expose
private String PhotoCaption;

/**
*
* @return
* The Photo
*/
public String getPhoto() {
return Photo;
}

/**
*
* @param Photo
* The Photo
*/
public void setPhoto(String Photo) {
this.Photo = Photo;
}

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
* The PhotoCaption
*/
public String getPhotoCaption() {
return PhotoCaption;
}

/**
*
* @param PhotoCaption
* The PhotoCaption
*/
public void setPhotoCaption(String PhotoCaption) {
this.PhotoCaption = PhotoCaption;
}
}
