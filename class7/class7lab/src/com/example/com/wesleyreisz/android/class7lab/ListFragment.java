package com.example.com.wesleyreisz.android.class7lab;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment  {
	
	private OnItemSelectedListener listener; 

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.list_fragment, container, false);
		
		Button button1 = (Button) view.findViewById(R.id.button1);
		Button button2 = (Button) view.findViewById(R.id.button2);
		Button button3 = (Button) view.findViewById(R.id.button3);
		Button button4 = (Button) view.findViewById(R.id.button4);
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateDetail("layout1");  
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateDetail("layout2");  
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateDetail("layout3");  
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateDetail("layout4");  
			}
		});

		return view;
	}
	
		@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);  
		if (activity instanceof OnItemSelectedListener) {  
			listener = (OnItemSelectedListener) activity;  
		} else {  
			throw new ClassCastException(
					activity.toString() + " must implemenet MyListFragment.OnItemSelectedListener"
			);  
		} 
	}
	
		
	// May also be triggered from the Activity  
	public void updateDetail(String s) {          
		listener.onRssItemSelected(s);  
	} 
	
	public interface OnItemSelectedListener{
		public void onRssItemSelected(String link);
	}
}
