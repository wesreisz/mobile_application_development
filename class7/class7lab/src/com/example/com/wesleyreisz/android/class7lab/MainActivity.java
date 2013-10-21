package com.example.com.wesleyreisz.android.class7lab;

import com.example.com.wesleyreisz.android.class7lab.fragments.Layout1;
import com.example.com.wesleyreisz.android.class7lab.fragments.Layout2;
import com.example.com.wesleyreisz.android.class7lab.fragments.Layout3;
import com.example.com.wesleyreisz.android.class7lab.fragments.Layout4;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity implements ListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        FragmentManager fragmentManager = getFragmentManager();  
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		
		fragmentTransaction.replace(R.id.detailFragment, new Layout1());  
		fragmentTransaction.commit(); 
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onRssItemSelected(String link) {
		FragmentManager fragmentManager = getFragmentManager();  
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); 
		
		Layout1 layout1; //Fragment 1  
		Layout2 layout2; //Fragment 2  
		Layout3 layout3; //Fragment 3  
		Layout4 layout4; //Fragment 4 
		
		
		if (link.equals("layout1")) {  
			layout1 = new Layout1();  
			fragmentTransaction.replace(R.id.detailFragment, layout1);  
			fragmentTransaction.commit();  
		} else if (link.equals("layout2")) {  
			layout2 = new Layout2();  
			fragmentTransaction.replace(R.id.detailFragment, layout2);  
			fragmentTransaction.commit();  
		} else if (link.equals("layout3")) {  
			layout3 = new Layout3();  
			fragmentTransaction.replace(R.id.detailFragment, layout3);  
			fragmentTransaction.commit();  
		} else if (link.equals("layout4")) {  
			layout4 = new Layout4();  
			fragmentTransaction.replace(R.id.detailFragment, layout4);  
			fragmentTransaction.commit();  
		} 
		
	}
    
}
