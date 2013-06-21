package com.rhysyu.soundapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SoundappActivity extends Activity {
	
	// add instrument here
	// final CharSequence[] instrumentlist={"Piano","Guitar","Drums","Misc."};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button multiplayerbutton = (Button) findViewById(R.id.multiplayer);
        multiplayerbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), BluetoothChat.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(myIntent, 0);
            	
              
            }

        });
        
        Button soloplaybutton = (Button) findViewById(R.id.soloplay);
        soloplaybutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), soloplayActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(myIntent, 0);
            }

        });
        
        Button instrumentslistbutton = (Button) findViewById(R.id.instrumentlist);
        instrumentslistbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), instrumentslistActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(myIntent, 0);
            }

        });
        
        
    }
    
    @Override
    public synchronized void onResume() {
        super.onResume();
    }
    
    @Override
    public synchronized void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    }
    
    public void about_Click(View v){
    	showAbout();
    }
    
    public void exit_Click(View v){
    	finish();
    	moveTaskToBack(true);
    }
    
    private void showAbout(){
    	final Dialog d = new Dialog(this);
    	d.setContentView(R.layout.aboutdialog);	
    	d.setTitle("About this App");
    	//set up button
        Button closebutton = (Button) d.findViewById(R.id.closeaboutdialog);
        closebutton.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		d.dismiss();
            }
        });
        d.show();
    }
}