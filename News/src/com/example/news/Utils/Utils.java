package com.example.news.Utils;

import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {
	
	// Times of india main URL
	public static final String URL = "http://timesofindia.indiatimes.com/feeds";
	
	public static final String STORY = "Key_Story";
	
	public static final String PHOTO = "Key_Photo";
	
	//Method to check intenet connection
	public static boolean isOnline(Context context) {
	    ConnectivityManager cm =
	            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
	        NetworkInfo netInfo = cm.getActiveNetworkInfo();
	        return netInfo != null && netInfo.isConnectedOrConnecting();
	    }
	
	 public static void CopyStream(InputStream is, OutputStream os)
	    {
	        final int buffer_size=1024;
	        try
	        {
	             
	            byte[] bytes=new byte[buffer_size];
	            for(;;)
	            {
	              //Read byte from input stream
	                 
	              int count=is.read(bytes, 0, buffer_size);
	              if(count==-1)
	                  break;
	               
	              //Write byte from output stream
	              os.write(bytes, 0, count);
	            }
	        }
	        catch(Exception ex){}
	    }
	
}
