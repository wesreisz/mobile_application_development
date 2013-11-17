package com.bignerdranch.android.criminalintent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import android.content.Context;
import android.util.Log;

public class CriminalIntentJSONSerializer {
	private static String TAG = "JSONFile";
	private Context mContent;
	private String mFileName;
	
	public CriminalIntentJSONSerializer(Context c, String f){
		this.mContent = c;
		this.mFileName = f;
	}
	
	 public List<Crime> loadCrimes() throws IOException, JSONException{
	    	List<Crime> crimes = new ArrayList<Crime>();
	    	BufferedReader reader = null;
	    	try {
				InputStream in = mContent.openFileInput(mFileName);
				reader = new BufferedReader(new InputStreamReader(in));
				
				StringBuilder jsonString = new StringBuilder();
				String line = null;
				while((line=reader.readLine())!=null){
					jsonString.append(line);
				}
				
				JSONArray array = (JSONArray)new JSONTokener(jsonString.toString())
					.nextValue();
				
				for(int i = 0; i<array.length(); i++){
					crimes.add(new Crime(array.getJSONObject(i)));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if(reader!=null){
					reader.close();
				}
			}
			return crimes;	
	    }
	 
	public void saveCrimes(List<Crime> crimes) throws JSONException, IOException{
		JSONArray array = new JSONArray();
		for(Crime c: crimes){
			array.put(c.toJSON());
		}
		
		Log.d(TAG,array.toString());
		Writer writer = null;
		try{
			OutputStream out = mContent
					.openFileOutput(mFileName, Context.MODE_PRIVATE);
			writer = new OutputStreamWriter(out);
			writer.write(array.toString());
		}finally{
			if(writer!=null){
				writer.close();
			}
		}
	}
}
