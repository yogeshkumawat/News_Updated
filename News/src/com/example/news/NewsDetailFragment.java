package com.example.news;

import com.example.news.Adapter.NewsAdapter;
import com.example.news.Adapter.NewsAdapter.DownloadImageTask;
import com.example.news.Utils.Utils;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailFragment extends Fragment {
	
	private String story = "";
	private String mPhotoUrl;
	private ImageView mImageView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// Inflate News Detail View
		View view = inflater.inflate(R.layout.detail_fragment_layout, container, false);
		mImageView = (ImageView) view.findViewById(R.id.news_photo);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Intent intent = getActivity().getIntent();
		
		//Get Detail of news from intent
		story = (String) intent.getCharSequenceExtra(Utils.STORY);
		mPhotoUrl = (String) intent.getCharSequenceExtra(Utils.PHOTO);
		new NewsAdapter().new DownloadImageTask(mImageView).execute(mPhotoUrl);
		//set Real Story to text view
		setText(story);
	}

	public void setText(String item) {
		
		WebView view = (WebView) getView().findViewById(R.id.display_tv);
		view.getSettings().setJavaScriptEnabled(true);
		Log.v("yogesh", ""+item);
		//view.loadUrl(item);
		String customHtml = "<html><body>"+item+"</body></html>";
		view.loadData(customHtml, "text/html", "UTF-8");
		//view.loadUrl(item);
	}

}
