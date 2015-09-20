package com.example.news;

import java.util.ArrayList;
import java.util.List;

import com.example.news.Adapter.NewsAdapter;
import com.example.news.Adapter.NewsAdapter.Holder;
import com.example.news.Utils.NewsRestClient;
import com.example.news.Utils.Utils;
import com.yogesh.News.Json.News;
import com.yogesh.News.Json.NewsItem;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class NewsListFragment extends Fragment {

	private Communicator communicator;
	private Context mContext;
	private List<NewsItem> mListTitle = new ArrayList<NewsItem>();
	private View view;
	private ListView mListView;
    private NewsAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// Inflate the list fragment view
		View view = inflater.inflate(R.layout.list_fragment_layout, container, false);
		mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_container);
		mSwipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_green_light,
				android.R.color.holo_orange_light,
				android.R.color.holo_red_light);
		
		mSwipeRefreshLayout.setOnRefreshListener(mRefreshListener);
		setHasOptionsMenu(true);
		this.view = view;
		
		return view;
	}
	
	OnRefreshListener mRefreshListener = new OnRefreshListener() {
		
		@Override
		public void onRefresh() {
			// TODO Auto-generated method stub
			refreshList();
		}
	};
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.news, menu);

	}
	
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onPrepareOptionsMenu(menu);
	}
	
	//Method to refresh the News List
	public void refreshList(){
		mListTitle.clear();
		getNewsList();
		//createList();
		
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mContext = activity;
		getNewsList();
		
		if (activity instanceof Communicator) {
			communicator = (Communicator) activity;
		} else {
			throw new ClassCastException(activity.toString() + " must implement MyListFragment.OnItemSelectedListener");
		}
	}

	// Create Interface
	public interface Communicator {
		public void Message(String OS_Name);
	}


	public void getNewsList() {
		
		//Check for internet
		if (Utils.isOnline(mContext)) {
			getNews();
		} else {
			Toast.makeText(mContext, R.string.info_offline, Toast.LENGTH_LONG).show();
		}
	}

	public void getNews() {
		Callback<News> callback = new Callback<News>() {

			@Override
			public void failure(RetrofitError resp) {
				Log.v("yogesh", "Failed: "+String.valueOf(resp.getCause()+resp.getMessage()));
			}

			@Override
			public void success(News info, Response resp) {
				Log.v("yogesh", "Success: "+String.valueOf(resp.getStatus()));
				getNewsItem(info);
				createList();
			}
		};
		NewsRestClient.initRestAdapter().getNews(
				callback);
	}

	public List<NewsItem> getNewsItem(News info) {
		for (int i = 0; i < info.getNewsItem().size(); i++) {
			NewsItem item = new NewsItem();
			item.setHeadLine(info.getNewsItem().get(i).getHeadLine());
			item.setStory(info.getNewsItem().get(i).getStory());
			item.setImage(info.getNewsItem().get(i).getImage());
			mListTitle.add(item);
		}
		return mListTitle;
	}

	public void createList() {
		if(mAdapter == null)
			mAdapter = new NewsAdapter(mContext, getActivity().getApplication(), mListTitle);
		
		setListAdapter(mAdapter);
		mSwipeRefreshLayout.setRefreshing(false);
	}

	protected void setListAdapter(NewsAdapter adapter) {
		mAdapter.setData(mListTitle);
		getListView().setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
	}

	//Inflate list of news
	protected ListView getListView() {
		if (mListView == null) {
			mListView = (ListView) view.findViewById(R.id.ptrstgv);
			mListView.setOnItemClickListener(itemClick);
		}
		
		return mListView;
	}
	
	OnItemClickListener itemClick = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			Holder holder = (NewsAdapter.Holder) view.getTag();
			String story = holder.story;
			String photo = holder.photoUrl;
			Intent i = new Intent(mContext, NewsDetailActivity.class);  //Start Detail Activity
			i.putExtra(Utils.STORY, story);
			i.putExtra(Utils.PHOTO, photo);
			mContext.startActivity(i);
		}
	};
	public class LoadMoreTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //mAdapter.getMoreItem();
            mAdapter.notifyDataSetChanged();
            super.onPostExecute(result);
        }

    }

}
