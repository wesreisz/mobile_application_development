package com.bignerdranch.android.criminalintent;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import android.content.Context;
import android.util.Log;

public class CrimeLab {
	private static final String TAG = "Crimelab";
	private static final String FILENAME = "crimes.json";
	
    private List<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private CriminalIntentJSONSerializer mSerializer;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        //mCrimes = new ArrayList<Crime>();
        try{
        	//create if it's null... this is not in the book
			if (mSerializer==null){
				mSerializer = new CriminalIntentJSONSerializer(mAppContext,FILENAME);
			}
			
        	mCrimes = mSerializer.loadCrimes();
        }catch(Exception e){
        	mCrimes = new ArrayList<Crime>();
        	Log.e(TAG,"Error loading crimes: " + e);
        }
    }

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }
    
    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public void deleteCrime(Crime c) {
        mCrimes.remove(c);
    }
    
    
    public boolean saveCrimes(){
		try {
			//create if it's null... this is not in the book
			if (mSerializer==null){
				mSerializer = new CriminalIntentJSONSerializer(mAppContext,FILENAME);
			}
			
			mSerializer.saveCrimes(mCrimes); //where is this created
			Log.d(TAG, "crimes saved");
			return true;
		} catch (JSONException e) {
			Log.d(TAG, "crimes failed to save: " + e.getMessage());
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			Log.d(TAG, "crimes failed to save: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	
    }
}

