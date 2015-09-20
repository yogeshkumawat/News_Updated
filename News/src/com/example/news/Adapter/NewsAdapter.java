package com.example.news.Adapter;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.news.R;
import com.squareup.picasso.Picasso;
import com.yogesh.News.Json.NewsItem;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private Context mContext;
    private List<NewsItem> mNewsItemList = new ArrayList<NewsItem>();
    public ImageLoader imageLoader;

    public NewsAdapter(Context context, Application app, List<NewsItem> item) {
        mContext = context;
        mNewsItemList = item;
        imageLoader = new ImageLoader(mContext);
    }
    public NewsAdapter() {
		// TODO Auto-generated constructor stub
	}

    public void setData(List<NewsItem> item) {
    	mNewsItemList = item;
    }
    @Override
    public int getCount() {
        return mNewsItemList == null ? 0 : mNewsItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder;
        if(mNewsItemList.size() < 1)
        	return convertView;
        String url = mNewsItemList.get(position).getImage().getThumb();
        String mPhotoUrl = mNewsItemList.get(position).getImage().getPhoto();

        if (convertView == null) {
        	holder = new Holder();
            view = View.inflate(mContext, R.layout.list_item, null);
            holder.img_content = (ImageView) view.findViewById(R.id.news_icon);
            holder.tv_info = (TextView) view.findViewById(R.id.news_head_line);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }


        holder.tv_info.setText(mNewsItemList.get(position).getHeadLine());
        //new DownloadImageTask(holder.img_content).execute(url);
        
        holder.story = mNewsItemList.get(position).getStory();
        holder.photoUrl = mPhotoUrl;
        ImageView image = holder.img_content;
        
      //DisplayImage function from ImageLoader Class
        imageLoader.DisplayImage(url, image);
        return view;
    }

    public static class Holder {
    	ImageView img_content;
        TextView tv_info;
        public String story;
        public String photoUrl;
    }
    
    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    	ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}
