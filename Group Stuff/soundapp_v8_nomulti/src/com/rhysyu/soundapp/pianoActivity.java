package com.rhysyu.soundapp;

import android.app.Activity;
import android.content.Intent;
import android.media.SoundPool;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pianoActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pianotone);
        
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    	final SoundPool soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
    	final int A_tone = soundPool.load(this, R.raw.a, 1);
    	final int B_tone = soundPool.load(this, R.raw.b, 1);
    	final int C_tone = soundPool.load(this, R.raw.c, 1);
    	final int D_tone = soundPool.load(this, R.raw.d, 1);
    	final int E_tone = soundPool.load(this, R.raw.e, 1);
    	final int F_tone = soundPool.load(this, R.raw.f, 1);
    	final int G_tone = soundPool.load(this, R.raw.g, 1);
    	final int Asharp_tone = soundPool.load(this, R.raw.a_sharp, 1);
    	final int Csharp_tone = soundPool.load(this, R.raw.c_sharp, 1);
    	final int Dsharp_tone = soundPool.load(this, R.raw.d_sharp, 1);
    	final int Fsharp_tone = soundPool.load(this, R.raw.f_sharp, 1);
    	final int Gsharp_tone = soundPool.load(this, R.raw.g_sharp, 1);
    	
        
        Button A_button = (Button) findViewById(R.id.pianoAkey);
        A_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
            	soundPool.play(A_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button B_button = (Button) findViewById(R.id.pianoBkey);
        B_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(B_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button C_button = (Button) findViewById(R.id.pianoCkey);
        C_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(C_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button D_button = (Button) findViewById(R.id.pianoDkey);
        D_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(D_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button E_button = (Button) findViewById(R.id.pianoEkey);
        E_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(E_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button F_button = (Button) findViewById(R.id.pianoFkey);
        F_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(F_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button G_button = (Button) findViewById(R.id.pianoGkey);
        G_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(G_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button Asharp_button = (Button) findViewById(R.id.pianoAsharpkey);
        Asharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(Asharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button Csharp_button = (Button) findViewById(R.id.pianoCsharpkey);
        Csharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(Csharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button Dsharp_button = (Button) findViewById(R.id.pianoDsharpkey);
        Dsharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(Dsharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button Fsharp_button = (Button) findViewById(R.id.pianoFsharpkey);
        Fsharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(Fsharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Button Gsharp_button = (Button) findViewById(R.id.pianoGsharpkey);
        Gsharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	soundPool.play(Gsharp_tone, 1, 1, 0, 0, 1);
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