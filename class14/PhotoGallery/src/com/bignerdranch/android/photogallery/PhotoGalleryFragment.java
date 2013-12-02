package com.bignerdranch.android.photogallery;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class PhotoGalleryFragment extends Fragment {
    GridView mGridView;
    ArrayList<GalleryItem> mItems;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setRetainInstance(true);
        //calls async task on background thread
        new FetchItemsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        
        mGridView = (GridView)v.findViewById(R.id.gridView);
        
        setupAdapter();
        
        return v;
    }
    
    void setupAdapter() {
        if (getActivity() == null || mGridView == null) return;
        
        if (mItems != null) {
        	//create a custom adapter
            mGridView.setAdapter(new GalleryItemAdapter(mItems));
        } else {
            mGridView.setAdapter(null);
        }
    }
    
    //creates an async task... this is the important part! see p421
    private class FetchItemsTask extends AsyncTask<Void,Void,ArrayList<GalleryItem>> {
        @Override
        protected ArrayList<GalleryItem> doInBackground(Void... params) {
            return new FlickrFetchr().fetchItems();
        }

        @Override
        protected void onPostExecute(ArrayList<GalleryItem> items) {
            mItems = items;
            setupAdapter();
        }
    }
    
    //create a class inside the fragment... this gives it scope to the getActivity
    private class GalleryItemAdapter extends ArrayAdapter<GalleryItem>{
    	public GalleryItemAdapter(ArrayList<GalleryItem> items){
    		super(getActivity(),0,items);
    	}
    	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
    		if(convertView == null){
    			convertView = getActivity().getLayoutInflater()
    					.inflate(R.layout.gallery_item, parent, false);
    		}
    		
    		ImageView imageView = (ImageView)convertView
    				.findViewById(R.id.gallery_item_imageView);
    		imageView.setImageResource(R.drawable.photo_placeholder_150_150);
    		
			return imageView;
		}
    }
}
