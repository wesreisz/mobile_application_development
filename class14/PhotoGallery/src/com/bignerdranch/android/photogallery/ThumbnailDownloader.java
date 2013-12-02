package com.bignerdranch.android.photogallery;

import android.os.HandlerThread;
import android.util.Log;

public class ThumbnailDownloader<Token> extends HandlerThread {
	private static final String TAG = "ThumbnailDownloader";
	public ThumbnailDownloader() {
		super(TAG);	
	}
	public void queueThumbnail(Token token, String url){
		Log.i(TAG, "got a url: " + url);
	}
}
