package com.rhysyu.soundapp;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;


public class soloplayActivity extends Activity {
	
	//private ListView lv;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soloplay);

    	//=================================== START INSTRUMENTS ==========================================
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
    	final SoundPool soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
    	
//    	Piano sounds
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

//    	Drums sounds
    	final int rim_tone = soundPool.load(this, R.raw.rim, 1);
    	final int ride_tone = soundPool.load(this, R.raw.ride, 1);
    	final int crash_tone = soundPool.load(this, R.raw.crash, 1);
    	final int hhopen_tone = soundPool.load(this, R.raw.hhopen, 1);
    	final int hhped_tone = soundPool.load(this, R.raw.hhped, 1);
    	final int hhcl_tone = soundPool.load(this, R.raw.hhcl, 1);
    	final int rk1_tone = soundPool.load(this, R.raw.rk1, 1);
    	final int rk3_tone = soundPool.load(this, R.raw.rk3, 1);
    	final int fl_tone = soundPool.load(this, R.raw.fl, 1);
    	final int sn_tone = soundPool.load(this, R.raw.sn, 1);
    	final int kik_tone = soundPool.load(this, R.raw.kik, 1);
    	
//    	Flute sounds
    	final int flute_A = soundPool.load(this, R.raw.flute_a, 1);
    	final int flute_B = soundPool.load(this, R.raw.flute_b, 1);
    	final int flute_C = soundPool.load(this, R.raw.flute_c, 1);
    	final int flute_D = soundPool.load(this, R.raw.flute_d, 1);
    	final int flute_E = soundPool.load(this, R.raw.flute_e, 1);
    	final int flute_F = soundPool.load(this, R.raw.flute_f, 1);
    	final int flute_G = soundPool.load(this, R.raw.flute_g, 1);
    	final int flute_C2 = soundPool.load(this, R.raw.flute_c2, 1);
    	
//    	Guitar sounds
    	final int A_tone_gtr = soundPool.load(this, R.raw.a_gtr, 1);
    	final int B_tone_gtr = soundPool.load(this, R.raw.b_gtr, 1);
    	final int C_tone_gtr = soundPool.load(this, R.raw.c_gtr, 1);
    	final int C2_tone_gtr = soundPool.load(this, R.raw.c2_gtr, 1);
    	final int D_tone_gtr = soundPool.load(this, R.raw.d_gtr, 1);
    	final int E_tone_gtr = soundPool.load(this, R.raw.e_gtr, 1);
    	final int F_tone_gtr = soundPool.load(this, R.raw.f_gtr, 1);
    	final int G_tone_gtr = soundPool.load(this, R.raw.g_gtr, 1);
    	final int Asharp_tone_gtr = soundPool.load(this, R.raw.a_sharp_gtr, 1);
    	final int Csharp_tone_gtr = soundPool.load(this, R.raw.c_sharp_gtr, 1);
    	final int Dsharp_tone_gtr = soundPool.load(this, R.raw.d_sharp_gtr, 1);
    	final int Fsharp_tone_gtr = soundPool.load(this, R.raw.f_sharp_gtr, 1);
    	final int Gsharp_tone_gtr = soundPool.load(this, R.raw.g_sharp_gtr, 1);

    	
    	Button mediaplayerbutton = (Button) findViewById(R.id.mediaplayer);
    	mediaplayerbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				finish();
				// intent to go to mediaplayer activity
				Intent myIntent = new Intent(view.getContext(), AndroidBuildingMusicPlayerActivity.class);
				myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(myIntent, 0);
			}
		});
    	
    	Button sounddialogbutton = (Button) findViewById(R.id.changesound);
    	sounddialogbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showSounds();
			}
		});
        
        
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
        
        
//        Guitar
        Button A_button_gtr = (Button) findViewById(R.id.guitarAkey);
    	A_button_gtr.setOnClickListener(new View.OnClickListener() {
    	 	@ Override
    	 	public void onClick(View view) {
    	 		// play tone
    	        	soundPool.play(A_tone_gtr, 1, 1, 0, 0, 1);
   	        }

    	});
    	    
   	    Button B_button_gtr = (Button) findViewById(R.id.guitarBkey);
   	    B_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(B_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
   	    
   	    Button C2_button_gtr = (Button) findViewById(R.id.guitarC2key);
   	    C2_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(C2_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button C_button_gtr = (Button) findViewById(R.id.guitarCkey);
   	    C_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(C_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button D_button_gtr = (Button) findViewById(R.id.guitarDkey);
   	    D_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(D_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button E_button_gtr = (Button) findViewById(R.id.guitarEkey);
   	    E_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(E_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button F_button_gtr = (Button) findViewById(R.id.guitarFkey);
   	    F_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(F_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button G_button_gtr = (Button) findViewById(R.id.guitarGkey);
   	    G_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(G_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button Asharp_button_gtr = (Button) findViewById(R.id.guitarAsharpkey);
   	    Asharp_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(Asharp_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button Csharp_button_gtr = (Button) findViewById(R.id.guitarCsharpkey);
   	    Csharp_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(Csharp_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button Dsharp_button_gtr = (Button) findViewById(R.id.guitarDsharpkey);
   	    Dsharp_button_gtr.setOnClickListener(new View.OnClickListener() {
   	    	public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(Dsharp_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button Fsharp_button_gtr = (Button) findViewById(R.id.guitarFsharpkey);
   	    Fsharp_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(Fsharp_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
    	    
   	    Button Gsharp_button_gtr = (Button) findViewById(R.id.guitarGsharpkey);
   	    Gsharp_button_gtr.setOnClickListener(new View.OnClickListener() {
   	        public void onClick(View view) {
   	            // play tone
   	        	soundPool.play(Gsharp_tone_gtr, 1, 1, 0, 0, 1);
   	        }

   	    });
      //=================================== END INSTRUMENTS ==========================================
    }
    
    
    //================================ START STANDALONE FUNCTIONS ==========================================
    private void showSounds(){
    	final Dialog d = new Dialog(this);
    	d.setContentView(R.layout.sounddialog);	
    	d.setTitle("Choose a sound");
    	//set up button
        Button closebutton = (Button) d.findViewById(R.id.closesounddialog);
        closebutton.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		d.dismiss();
            }
        });
        
        Button pianobutton = (Button) d.findViewById(R.id.soundchoosepiano);
        pianobutton.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		showPiano();
        		d.dismiss();
            }
        });
        
        Button drumsbutton = (Button) d.findViewById(R.id.soundchoosedrums);
        drumsbutton.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		showDrums();
        		d.dismiss();
            }
        });
        
        Button flutebutton = (Button) d.findViewById(R.id.soundchooseflute);
        flutebutton.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		showFlute();
        		d.dismiss();
            }
        });
        
        Button guitarbutton = (Button) d.findViewById(R.id.soundchooseguitar);
        guitarbutton.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		showGuitar();
        		d.dismiss();
            }
        });
        
    
        Button miscbutton = (Button) d.findViewById(R.id.soundchoosemisc);
        miscbutton.setOnClickListener(new OnClickListener() {
        @Override
            public void onClick(View v) {
        		showMisc();
        		d.dismiss();
            }
        });
        d.show();
    }
    
    private void showPiano(){
    	RelativeLayout pianolayout = (RelativeLayout)findViewById(R.id.piano_layout);
    	RelativeLayout drumslayout = (RelativeLayout)findViewById(R.id.drums_layout);
    	RelativeLayout flutelayout = (RelativeLayout)findViewById(R.id.flute_layout);
    	RelativeLayout guitarlayout = (RelativeLayout)findViewById(R.id.guitar_layout);
    	RelativeLayout misclayout = (RelativeLayout)findViewById(R.id.misc_layout);
    	
    	pianolayout.setVisibility(View.VISIBLE);
    	drumslayout.setVisibility(View.GONE);
    	flutelayout.setVisibility(View.GONE);
    	guitarlayout.setVisibility(View.GONE);
    	misclayout.setVisibility(View.GONE);
    }
    
    private void showDrums(){
    	RelativeLayout pianolayout = (RelativeLayout)findViewById(R.id.piano_layout);
    	RelativeLayout drumslayout = (RelativeLayout)findViewById(R.id.drums_layout);
    	RelativeLayout flutelayout = (RelativeLayout)findViewById(R.id.flute_layout);
    	RelativeLayout guitarlayout = (RelativeLayout)findViewById(R.id.guitar_layout);
    	RelativeLayout misclayout = (RelativeLayout)findViewById(R.id.misc_layout);

    	pianolayout.setVisibility(View.GONE);
    	drumslayout.setVisibility(View.VISIBLE);
    	flutelayout.setVisibility(View.GONE);
    	guitarlayout.setVisibility(View.GONE);
    	misclayout.setVisibility(View.GONE);
    }
    
    private void showFlute(){
    	RelativeLayout pianolayout = (RelativeLayout)findViewById(R.id.piano_layout);
    	RelativeLayout drumslayout = (RelativeLayout)findViewById(R.id.drums_layout);
    	RelativeLayout flutelayout = (RelativeLayout)findViewById(R.id.flute_layout);
    	RelativeLayout guitarlayout = (RelativeLayout)findViewById(R.id.guitar_layout);
    	RelativeLayout misclayout = (RelativeLayout)findViewById(R.id.misc_layout);

    	pianolayout.setVisibility(View.GONE);
    	drumslayout.setVisibility(View.GONE);
    	flutelayout.setVisibility(View.VISIBLE);
    	guitarlayout.setVisibility(View.GONE);
    	misclayout.setVisibility(View.GONE);
    }
    
    private void showGuitar(){
    	RelativeLayout pianolayout = (RelativeLayout)findViewById(R.id.piano_layout);
    	RelativeLayout drumslayout = (RelativeLayout)findViewById(R.id.drums_layout);
    	RelativeLayout flutelayout = (RelativeLayout)findViewById(R.id.flute_layout);
    	RelativeLayout guitarlayout = (RelativeLayout)findViewById(R.id.guitar_layout);
    	RelativeLayout misclayout = (RelativeLayout)findViewById(R.id.misc_layout);

    	pianolayout.setVisibility(View.GONE);
    	drumslayout.setVisibility(View.GONE);
    	flutelayout.setVisibility(View.GONE);
    	guitarlayout.setVisibility(View.VISIBLE);
    	misclayout.setVisibility(View.GONE);
    }
    
    private void showMisc(){
    	RelativeLayout pianolayout = (RelativeLayout)findViewById(R.id.piano_layout);
    	RelativeLayout drumslayout = (RelativeLayout)findViewById(R.id.drums_layout);
    	RelativeLayout flutelayout = (RelativeLayout)findViewById(R.id.flute_layout);
    	RelativeLayout guitarlayout = (RelativeLayout)findViewById(R.id.guitar_layout);
    	RelativeLayout misclayout = (RelativeLayout)findViewById(R.id.misc_layout);

    	pianolayout.setVisibility(View.GONE);
    	drumslayout.setVisibility(View.GONE);
    	flutelayout.setVisibility(View.GONE);
    	guitarlayout.setVisibility(View.GONE);
    	misclayout.setVisibility(View.VISIBLE);
    }
    
   //================================ END STANDALONE FUNCTIONS ==========================================
    
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