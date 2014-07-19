package com.as.schat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class SChatApplication extends Application{

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, "nstr1SnoFuObHwFAWd7xHOAd4IRCMJDBmVemI62D", "tDNlCOFlGIFU5GB06MfWdzhgwtQnzEUUXovbKNUG");
	}

}
