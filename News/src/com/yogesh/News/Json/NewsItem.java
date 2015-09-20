package com.yogesh.News.Json;

import com.google.gson.annotations.Expose;

public class NewsItem {


@Expose
private String HeadLine;

@Expose
private String Story;

@Expose
private Image Image;

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
* The Story
*/
public String getStory() {
return Story;
}

/**
*
* @param Story
* The Story
*/
public void setStory(String Story) {
this.Story = Story;
}
/**
*
* @return
* The HeadLine
*/
public Image getImage() {
return Image;
}

/**
*
* @param HeadLine
* The HeadLine
*/
public void setImage(Image Image) {
this.Image = Image;
}

}