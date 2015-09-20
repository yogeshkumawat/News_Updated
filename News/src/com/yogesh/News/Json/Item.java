package com.yogesh.News.Json;

public class Item
{
    private String Story;

    private String NewsItemId;

    private String Caption;

    private String CommentCountUrl;

    private String WebURL;

    private String ByLine;

    private String Related;

    private String HeadLine;

    private String DateLine;

    private String Keywords;

    private String CommentFeedUrl;

    public String getStory ()
    {
        return Story;
    }

    public void setStory (String Story)
    {
        this.Story = Story;
    }

    public String getNewsItemId ()
    {
        return NewsItemId;
    }

    public void setNewsItemId (String NewsItemId)
    {
        this.NewsItemId = NewsItemId;
    }

    public String getCaption ()
    {
        return Caption;
    }

    public void setCaption (String Caption)
    {
        this.Caption = Caption;
    }

    public String getCommentCountUrl ()
    {
        return CommentCountUrl;
    }

    public void setCommentCountUrl (String CommentCountUrl)
    {
        this.CommentCountUrl = CommentCountUrl;
    }

    public String getWebURL ()
    {
        return WebURL;
    }

    public void setWebURL (String WebURL)
    {
        this.WebURL = WebURL;
    }

    public String getByLine ()
    {
        return ByLine;
    }

    public void setByLine (String ByLine)
    {
        this.ByLine = ByLine;
    }

    public String getRelated ()
    {
        return Related;
    }

    public void setRelated (String Related)
    {
        this.Related = Related;
    }

    public String getHeadLine ()
    {
        return HeadLine;
    }

    public void setHeadLine (String HeadLine)
    {
        this.HeadLine = HeadLine;
    }

    public String getDateLine ()
    {
        return DateLine;
    }

    public void setDateLine (String DateLine)
    {
        this.DateLine = DateLine;
    }

    public String getKeywords ()
    {
        return Keywords;
    }

    public void setKeywords (String Keywords)
    {
        this.Keywords = Keywords;
    }

    public String getCommentFeedUrl ()
    {
        return CommentFeedUrl;
    }

    public void setCommentFeedUrl (String CommentFeedUrl)
    {
        this.CommentFeedUrl = CommentFeedUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Story = "+Story+", NewsItemId = "+NewsItemId+", Caption = "+Caption+", CommentCountUrl = "+CommentCountUrl+", WebURL = "+WebURL+", ByLine = "+ByLine+", Related = "+Related+", HeadLine = "+HeadLine+", DateLine = "+DateLine+", Keywords = "+Keywords+", CommentFeedUrl = "+CommentFeedUrl+"]";
    }
}