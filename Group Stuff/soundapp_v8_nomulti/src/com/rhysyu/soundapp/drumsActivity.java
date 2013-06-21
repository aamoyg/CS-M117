package com.rhysyu.soundapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class drumsActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drumstone);
        
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    	final SoundPool soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
    	final int rim_tone = soundPool.load(this, R.raw.rim, 1);
    	final int ride_tone = soundPool.load(this, R.raw.ride, 1);
    	final int crash_tone = soundPool.load(this, R.raw.crash, 1);
    	final int hhopen_tone = soundPool.load(this, R.raw.hhopen, 1);
    	final int hhped_tone = soundPool.load(this, R.raw.hhped, 1);
    	final int hhcl_tone = soundPool.load(this, R.raw.hhcl, 1);
    	final int rk1_tone = soundPool.load(this, R.raw.rk1, 1);
    	//final int rk2_tone = soundPool.load(this, R.raw.rk2, 1);
    	final int rk3_tone = soundPool.load(this, R.raw.rk3, 1);
    	final int fl_tone = soundPool.load(this, R.raw.fl, 1);
    	final int sn_tone = soundPool.load(this, R.raw.sn, 1);
    	final int kik_tone = soundPool.load(this, R.raw.kik, 1);
        
        Button rim_button = (Button) findViewById(R.id.drums_rim_key);
        rim_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(rim_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button ride_button = (Button) findViewById(R.id.drums_ride_key);
        ride_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(ride_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button crash_button = (Button) findViewById(R.id.drums_crash_key);
        crash_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(crash_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button hhopen_button = (Button) findViewById(R.id.drums_hhopen_key);
        hhopen_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(hhopen_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button hhped_button = (Button) findViewById(R.id.drums_hhped_key);
        hhped_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(hhped_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button hhcl_button = (Button) findViewById(R.id.drums_hhcl_key);
        hhcl_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(hhcl_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button rk1_button = (Button) findViewById(R.id.drums_rk1_key);
        rk1_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(rk1_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button rk3_button = (Button) findViewById(R.id.drums_rk3_key);
        rk3_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(rk3_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button fl_button = (Button) findViewById(R.id.drums_fl_key);
        fl_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(fl_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button sn_button = (Button) findViewById(R.id.drums_sn_key);
        sn_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(sn_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button kik_button = (Button) findViewById(R.id.drums_kik_key);
        kik_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(kik_tone, 1, 1, 0, 0, 1);
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
    
}