package com.wesleyreisz.android.criminalintent.model;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

public class Crime {
	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mSolved;
	
	private static final String JSON_ID = "id";
	private static final String JSON_TITLE = "title";
	private static final String JSON_DATE = "date";
	private static final String JSON_SOLVED = "solved";
	
	public Crime(){
		mId=UUID.randomUUID();
		mDate= new Date();
	}
	public Crime(JSONObject json) throws JSONException{
		this.mId = UUID.fromString(json.getString(JSON_ID));
		this.mTitle = json.getString(JSON_TITLE);
		this.mSolved = json.getBoolean(JSON_SOLVED);
		this.mDate = new Date(json.getLong(JSON_DATE));
	}
	
	public UUID getId() {
		return mId;
	}
	
	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String title) {
		this.mTitle = title;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date mDate) {
		this.mDate = mDate;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean mSolved) {
		this.mSolved = mSolved;
	}
	
	@Override
	public String toString() {
		return mTitle + " (" + mId + "): " + mSolved;
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_ID, this.mId);
		json.put(JSON_TITLE,this.mTitle);
		json.put(JSON_DATE, this.mDate.getTime());
		json.put(JSON_SOLVED, this.mSolved);
		return json;
	}
	
}
