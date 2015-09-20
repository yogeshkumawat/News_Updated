package com.example.news;

import android.app.Activity;
import android.os.Bundle;

public class NewsActivity extends Activity implements NewsListFragment.Communicator {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
	}
	
	//overidden method from fragment to interact with another fragments
	@Override
	public void Message(String OS_Name) {
		// TODO Auto-generated method stub
		
	}

}
