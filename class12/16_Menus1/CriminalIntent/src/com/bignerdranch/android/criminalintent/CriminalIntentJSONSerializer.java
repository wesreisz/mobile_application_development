package com.bignerdranch.android.criminalintent;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;

public class CriminalIntentJSONSerializer {
	private Context mContent;
	private String mFileName;
	
	public CriminalIntentJSONSerializer(Context c, String f){
		this.mContent = c;
		this.mFileName = f;
	}
	
	public void saveCrimes(List<Crime> crimes) throws JSONException, IOException{
		JSONArray array = new JSONArray();
		for(Crime c: crimes){
			array.put(c.toJSON());
		}
		
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
