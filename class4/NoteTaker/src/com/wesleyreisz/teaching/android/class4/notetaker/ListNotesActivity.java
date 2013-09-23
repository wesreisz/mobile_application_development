package com.wesleyreisz.teaching.android.class4.notetaker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListNotesActivity extends Activity {
	private List<Note> notes = new ArrayList<Note>();
	private ListView listNotesView;
	private int editingNoteId = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_notes);
		
		listNotesView = (ListView)findViewById(R.id.listNotes);
		listNotesView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int itemNumber,
					long id) {
				Intent editNoteIntent = new Intent(view.getContext(),EditNoteActivity.class);
				editNoteIntent.putExtra("note", notes.get(itemNumber));
				editingNoteId = itemNumber;
				startActivityForResult(editNoteIntent, 1);
			}
		});

		notes.add(new Note("Note 1", "Super Special Note 1 Details", new Date()));
		notes.add(new Note("Note 2", "Super Special Note 2 Details", new Date()));
		notes.add(new Note("Note 3", "Super Special Note 3 Details", new Date()));
		notes.add(new Note("Note 4", "Super Special Note 4 Details", new Date()));
		notes.add(new Note("Note 5", "Super Special Note 5 Details", new Date()));
		
		populateList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_notes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent editIntent = new Intent(this,EditNoteActivity.class);
		startActivityForResult(editIntent, 1);
		return true;
	}

	private void populateList() {
		List<String> values = new ArrayList<String>();
		for(Note note:notes){
			values.add(note.getTitle());
		}
		
		//step 2 create an adapter
		ArrayAdapter<String>adapter = 
			new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_1,android.R.id.text1,values
			);
		
		listNotesView.setAdapter(adapter);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Serializable extra = data.getSerializableExtra("note");
		if(extra!=null){
			Note note = (Note)extra;
			if (editingNoteId>-1){
				notes.set(editingNoteId, note);
				editingNoteId = -1;
			}else{
				notes.add(note);
			}
			
			populateList();
		}
	}

}
