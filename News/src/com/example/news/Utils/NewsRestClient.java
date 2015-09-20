package com.example.news.Utils;

import com.squareup.okhttp.OkHttpClient;
import com.yogesh.News.Json.News;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.http.GET;

public class NewsRestClient {

	public interface ClientInterface{
		//Times India query
		@GET("/newsdefaultfeeds.cms?feedtype=sjson")
        void getNews(Callback<News> callback);

		}
	
	public static ClientInterface initRestAdapter()
    {
        OkHttpClient client = new OkHttpClient();

        return (ClientInterface) new RestAdapter.Builder()
                .setClient(new OkClient(client))
                .setEndpoint(Utils.URL)
                .build()
                .create(ClientInterface.class);
    }

}
