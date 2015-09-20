package com.yogesh.News.Json;

import com.google.gson.annotations.Expose;

public class Pagination {

@Expose
private String TotalPages;
@Expose
private String PageNo;
@Expose
private String PerPage;
@Expose
private String WebURL;

/**
*
* @return
* The TotalPages
*/
public String getTotalPages() {
return TotalPages;
}

/**
*
* @param TotalPages
* The TotalPages
*/
public void setTotalPages(String TotalPages) {
this.TotalPages = TotalPages;
}

/**
*
* @return
* The PageNo
*/
public String getPageNo() {
return PageNo;
}

/**
*
* @param PageNo
* The PageNo
*/
public void setPageNo(String PageNo) {
this.PageNo = PageNo;
}

/**
*
* @return
* The PerPage
*/
public String getPerPage() {
return PerPage;
}

/**
*
* @param PerPage
* The PerPage
*/
public void setPerPage(String PerPage) {
this.PerPage = PerPage;
}

/**
*
* @return
* The WebURL
*/
public String getWebURL() {
return WebURL;
}

/**
*
* @param WebURL
* The WebURL
*/
public void setWebURL(String WebURL) {
this.WebURL = WebURL;
}

}