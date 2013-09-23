package com.wesleyreisz.teaching.android.class4.notetaker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private boolean isInEditMode = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button btnSave = (Button)findViewById(R.id.btnNote);
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText txtTitle = (EditText)findViewById(R.id.txtTitle);
				EditText txtNotes = (EditText)findViewById(R.id.txtNotes);
				
				if(isInEditMode){
					isInEditMode=false;
					txtTitle.setEnabled(false);
					txtNotes.setEnabled(false);
					btnSave.setText("Edit");
					
					TextView lastUpdated = (TextView)findViewById(R.id.txtLastUpdated);
					DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
					String date = dateFormat.format(Calendar.getInstance().getTime());
					lastUpdated.setText(date);
					
				}else{
					isInEditMode=true;
					
					txtTitle.setEnabled(true);
					txtNotes.setEnabled(true);
					btnSave.setText("Save");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
