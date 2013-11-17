package com.bignerdranch.android.criminalintent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONException;

import android.content.Context;
import android.util.Log;

public class CrimeLab {
	private static final String TAG = "Crimelab";
	private static final String FILENAME = "crimes.json";
	
    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private CriminalIntentJSONSerializer mSerializer;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
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

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public void deleteCrime(Crime c) {
        mCrimes.remove(c);
    }
    
    public boolean saveCrimes(){
		try {
			mSerializer.saveCrimes(mCrimes);
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

