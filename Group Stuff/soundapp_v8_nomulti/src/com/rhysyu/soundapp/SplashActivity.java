package com.rhysyu.soundapp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashActivity extends Activity{
	private long splashdelay = 1500;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		TimerTask task = new TimerTask(){
			@Override
			public void run(){
				finish();
				Intent i = new Intent();
				i.setClass(SplashActivity.this, SoundappActivity.class);
				startActivity(i);
			}
		};
		
		Timer t = new Timer();
		t.schedule(task, splashdelay);
	}
	
	@Override
    public void onDestroy() {
      super.onDestroy();
    }
}