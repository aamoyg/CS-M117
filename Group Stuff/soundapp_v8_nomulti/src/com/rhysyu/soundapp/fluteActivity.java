package com.rhysyu.soundapp;

import android.app.Activity;
import android.content.Intent;
import android.media.SoundPool;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fluteActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flutetone);
        
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    	final SoundPool soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
    	final int flute_A = soundPool.load(this, R.raw.flute_a, 1);
    	final int flute_B = soundPool.load(this, R.raw.flute_b, 1);
    	final int flute_C = soundPool.load(this, R.raw.flute_c, 1);
    	final int flute_D = soundPool.load(this, R.raw.flute_d, 1);
    	final int flute_E = soundPool.load(this, R.raw.flute_e, 1);
    	final int flute_F = soundPool.load(this, R.raw.flute_f, 1);
    	final int flute_G = soundPool.load(this, R.raw.flute_g, 1);
    	final int flute_C2 = soundPool.load(this, R.raw.flute_c2, 1);

           
        Button fluteAbutton = (Button) findViewById(R.id.fluteakey);
        fluteAbutton.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_A, 1, 1, 0, 0, 1);
            }

        });
        
        Button fluteBbutton = (Button) findViewById(R.id.flutebkey);
        fluteBbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_B, 1, 1, 0, 0, 1);
            }

        });
        
        Button fluteCbutton = (Button) findViewById(R.id.fluteckey);
        fluteCbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_C, 1, 1, 0, 0, 1);
            }

        });
        
        Button fluteC2button = (Button) findViewById(R.id.flutec2key);
        fluteC2button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_C2, 1, 1, 0, 0, 1);
            }

        });
        
        Button fluteDbutton = (Button) findViewById(R.id.flutedkey);
        fluteDbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_D, 1, 1, 0, 0, 1);
            }

        });
        
        Button fluteEbutton = (Button) findViewById(R.id.fluteekey);
        fluteEbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_E, 1, 1, 0, 0, 1);
            }

        });
        
        Button fluteFbutton = (Button) findViewById(R.id.flutefkey);
        fluteFbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_F, 1, 1, 0, 0, 1);
            }

        });
        
        Button fluteGbutton = (Button) findViewById(R.id.flutegkey);
        fluteGbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(flute_G, 1, 1, 0, 0, 1);
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