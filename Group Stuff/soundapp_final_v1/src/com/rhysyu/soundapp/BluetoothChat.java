/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rhysyu.soundapp;

import android.app.Activity;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the main Activity that displays the current chat session.
 */
public class BluetoothChat extends Activity {
    // Debugging
    private static final String TAG = "BluetoothChat";
    private static final boolean D = true;

    // Message types sent from the BluetoothChatService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    // Intent request codes
    private static final int REQUEST_CONNECT_DEVICE = 1;
    private static final int REQUEST_ENABLE_BT = 2;

    // Layout Views
    private TextView mTitle;
    private ListView mConversationView;
    private EditText mOutEditText;
    private Button mSendButton;

    // Name of the connected device
    private String mConnectedDeviceName = null;
    // Array adapter for the conversation thread
    private ArrayAdapter<String> mConversationArrayAdapter;
    // String buffer for outgoing messages
    private StringBuffer mOutStringBuffer;
    // Local Bluetooth adapter
    private BluetoothAdapter mBluetoothAdapter = null;
    // Member object for the chat services
    private BluetoothChatService mChatService = null;


    public static final int A_TONE = 1;
    public static final int B_TONE = 2;
    public static final int C_TONE = 3;
    public static final int D_TONE = 4;
    public static final int E_TONE = 5;
    public static final int F_TONE = 6;
    public static final int G_TONE = 7;
    public static final int A_SHARP_TONE = 8;
    public static final int C_SHARP_TONE = 9;
    public static final int D_SHARP_TONE = 10;
    public static final int F_SHARP_TONE = 11;
    public static final int G_SHARP_TONE = 12;
    public static final int RIM_TONE = 13;
    public static final int RIDE_TONE = 14;
    public static final int CRASH_TONE = 15;
    public static final int HHOPEN_TONE = 16;
    public static final int HHPED_TONE = 17;
    public static final int HHCL_TONE = 18;
    public static final int RK1_TONE = 19;
    public static final int RK3_TONE = 20;
    public static final int FL_TONE = 21;
    public static final int SN_TONE = 22;
    public static final int KIK_TONE = 23;

    public static final int FLUTE_A = 24;
    public static final int FLUTE_B = 25;
    public static final int FLUTE_C = 26;
    public static final int FLUTE_D = 27;
    public static final int FLUTE_E = 28;
    public static final int FLUTE_F = 29;
    public static final int FLUTE_G = 30;    
    public static final int FLUTE_C2 = 31;

    public static final int A_TONE_GTR = 32;
    public static final int B_TONE_GTR = 33;
    public static final int C_TONE_GTR = 34;
    public static final int C2_TONE_GTR = 35;
    public static final int D_TONE_GTR = 36;
    public static final int E_TONE_GTR = 37;
    public static final int F_TONE_GTR = 38;
    public static final int G_TONE_GTR = 39;
    public static final int ASHARP_TONE_GTR = 40;
    public static final int CSHARP_TONE_GTR = 41;
    public static final int DSHARP_TONE_GTR = 42;
    public static final int FSHARP_TONE_GTR = 43;
    public static final int GSHARP_TONE_GTR = 44;

    private SoundPool soundPool;
	private int A_tone; //1
	private int B_tone; //2
	private int C_tone; //3
	private int D_tone; //4
	private int E_tone; //5
	private int F_tone; //6
	private int G_tone; //7
	private int Asharp_tone; //8
	private int Csharp_tone; //9
	private int Dsharp_tone; //10
	private int Fsharp_tone; //11
	private int Gsharp_tone; //12
	private int rim_tone; //13
	private int ride_tone; //14
	private int crash_tone; //15
	private int hhopen_tone; //16
	private int hhped_tone; //17
	private int hhcl_tone; //18
	private int rk1_tone; //19
	private int rk3_tone; //20
	private int fl_tone; //21
	private int sn_tone; //22
	private int kik_tone; //23
	
    // Flute sounds
	private int flute_A; //24
	private int flute_B; //25
	private int flute_C; //26
	private int flute_D; //27
	private int flute_E; //28
	private int flute_F; //29
	private int flute_G; //30
	private int flute_C2; //31

	// Guitar sounds
	private int A_tone_gtr; //32
	private int B_tone_gtr; //33
	private int C_tone_gtr; //34
	private int C2_tone_gtr; //35
	private int D_tone_gtr; //36
	private int E_tone_gtr; //37
	private int F_tone_gtr; //38
	private int G_tone_gtr; //39
	private int Asharp_tone_gtr; //40
	private int Csharp_tone_gtr; //41
	private int Dsharp_tone_gtr; //42
	private int Fsharp_tone_gtr; //43
	private int Gsharp_tone_gtr; //44
	
	private Button mediaplayerbutton;
	private Button sounddialogbutton;
	private Button A_button;
	private Button B_button;
	private Button C_button;
	private Button D_button;
	private Button E_button;
	private Button F_button;
	private Button G_button;
	private Button Asharp_button;
	private Button Csharp_button;
	private Button Dsharp_button;
	private Button Fsharp_button;
	private Button Gsharp_button;
	private Button rim_button;
	private Button ride_button;
	private Button crash_button;
	private Button hhopen_button;
	private Button hhped_button;
	private Button hhcl_button;
	private Button rk1_button;
	private Button rk3_button;
	private Button fl_button;
	private Button sn_button;
	private Button kik_button;

    // Flute buttons 
    private Button fluteAbutton;
    private Button fluteBbutton;
    private Button fluteCbutton;
    private Button fluteC2button;
    private Button fluteDbutton;
    private Button fluteEbutton;
    private Button fluteFbutton;
    private Button fluteGbutton;

    // Guitar buttons
    private Button A_button_gtr;
    private Button B_button_gtr;
    private Button C2_button_gtr; 
    private Button C_button_gtr;
    private Button D_button_gtr;
    private Button E_button_gtr;
    private Button F_button_gtr;
    private Button G_button_gtr;
    private Button Asharp_button_gtr;
    private Button Csharp_button_gtr;
    private Button Dsharp_button_gtr;
    private Button Fsharp_button_gtr;
    private Button Gsharp_button_gtr;


	public void initializeSoundPool(){
		soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        // Piano
		A_tone = soundPool.load(this, R.raw.a, 1); //1
		B_tone = soundPool.load(this, R.raw.b, 1); //2
		C_tone = soundPool.load(this, R.raw.c, 1); //3
		D_tone = soundPool.load(this, R.raw.d, 1); //4
		E_tone = soundPool.load(this, R.raw.e, 1); //5
		F_tone = soundPool.load(this, R.raw.f, 1); //6
		G_tone = soundPool.load(this, R.raw.g, 1); //7
		Asharp_tone = soundPool.load(this, R.raw.a_sharp, 1); //8
		Csharp_tone = soundPool.load(this, R.raw.c_sharp, 1); //9
		Dsharp_tone = soundPool.load(this, R.raw.d_sharp, 1); //10
		Fsharp_tone = soundPool.load(this, R.raw.f_sharp, 1); //11
		Gsharp_tone = soundPool.load(this, R.raw.g_sharp, 1); //12

        // Drums
		rim_tone = soundPool.load(this, R.raw.rim, 1); //13
		ride_tone = soundPool.load(this, R.raw.ride, 1); //14
		crash_tone = soundPool.load(this, R.raw.crash, 1); //15
		hhopen_tone = soundPool.load(this, R.raw.hhopen, 1); //16
		hhped_tone = soundPool.load(this, R.raw.hhped, 1); //17
		hhcl_tone = soundPool.load(this, R.raw.hhcl, 1); //18
		rk1_tone = soundPool.load(this, R.raw.rk1, 1); //19
		rk3_tone = soundPool.load(this, R.raw.rk3, 1); //20
		fl_tone = soundPool.load(this, R.raw.fl, 1); //21
		sn_tone = soundPool.load(this, R.raw.sn, 1); //22
		kik_tone = soundPool.load(this, R.raw.kik, 1); //23

        // Flute
        flute_A = soundPool.load(this, R.raw.flute_a, 1);
        flute_B = soundPool.load(this, R.raw.flute_b, 1);
        flute_C = soundPool.load(this, R.raw.flute_c, 1);
        flute_D = soundPool.load(this, R.raw.flute_d, 1);
        flute_E = soundPool.load(this, R.raw.flute_e, 1);
        flute_F = soundPool.load(this, R.raw.flute_f, 1);
        flute_G = soundPool.load(this, R.raw.flute_g, 1);
        flute_C2 = soundPool.load(this, R.raw.flute_c2, 1);

        // Guitar
        A_tone_gtr = soundPool.load(this, R.raw.a_gtr, 1);
        B_tone_gtr = soundPool.load(this, R.raw.b_gtr, 1);
        C_tone_gtr = soundPool.load(this, R.raw.c_gtr, 1);
        C2_tone_gtr = soundPool.load(this, R.raw.c2_gtr, 1);
        D_tone_gtr = soundPool.load(this, R.raw.d_gtr, 1);
        E_tone_gtr = soundPool.load(this, R.raw.e_gtr, 1);
        F_tone_gtr = soundPool.load(this, R.raw.f_gtr, 1);
        G_tone_gtr = soundPool.load(this, R.raw.g_gtr, 1);
        Asharp_tone_gtr = soundPool.load(this, R.raw.a_sharp_gtr, 1);
        Csharp_tone_gtr = soundPool.load(this, R.raw.c_sharp_gtr, 1);
        Dsharp_tone_gtr = soundPool.load(this, R.raw.d_sharp_gtr, 1);
        Fsharp_tone_gtr = soundPool.load(this, R.raw.f_sharp_gtr, 1);
        Gsharp_tone_gtr = soundPool.load(this, R.raw.g_sharp_gtr, 1);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(D) Log.e(TAG, "+++ ON CREATE +++");

        initializeSoundPool();
        // Set up the window layout
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.multiplay);
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title);

        if(D) Log.e(TAG, "FINISHED SETUP WINDOW LAYOUT");
        
        // Set up the custom title
        //mTitle = (TextView) findViewById(R.id.title_left_text);
        //mTitle.setText(R.string.app_name);
        //mTitle = (TextView) findViewById(R.id.title_right_text);

        if(D) Log.e(TAG, "FINISHED SETUP CUSTOM TITLE");
        
        // Get local Bluetooth adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // If the adapter is null, then Bluetooth is not supported
        if (mBluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        if(D) Log.e(TAG, "FINISHED CHECKING FOR BLUETOOTH ADAPTER");
        
        mediaplayerbutton = (Button) findViewById(R.id.mediaplayer);
    	mediaplayerbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				finish();
				// intent to go to mediaplayer activity
				Intent myIntent = new Intent(view.getContext(), AndroidBuildingMusicPlayerActivity.class);
				myIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
                startActivityForResult(myIntent, 0);
			}
		});
    	
    	sounddialogbutton = (Button) findViewById(R.id.changesound);
    	sounddialogbutton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showSounds();
			}
		});
        
        
        A_button = (Button) findViewById(R.id.pianoAkey);
        A_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("1");
            	soundPool.play(A_tone, 1, 1, 0, 0, 1);
            }

        });
        
        B_button = (Button) findViewById(R.id.pianoBkey);
        B_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("2");
            	soundPool.play(B_tone, 1, 1, 0, 0, 1);
            }

        });
        
        C_button = (Button) findViewById(R.id.pianoCkey);
        C_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("3");
            	soundPool.play(C_tone, 1, 1, 0, 0, 1);
            }

        });
        
        D_button = (Button) findViewById(R.id.pianoDkey);
        D_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("4");
            	soundPool.play(D_tone, 1, 1, 0, 0, 1);
            }

        });
        
        E_button = (Button) findViewById(R.id.pianoEkey);
        E_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("5");
            	soundPool.play(E_tone, 1, 1, 0, 0, 1);
            }

        });
        
        F_button = (Button) findViewById(R.id.pianoFkey);
        F_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("6");
            	soundPool.play(F_tone, 1, 1, 0, 0, 1);
            }

        });
        
        G_button = (Button) findViewById(R.id.pianoGkey);
        G_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("7");
            	soundPool.play(G_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Asharp_button = (Button) findViewById(R.id.pianoAsharpkey);
        Asharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("8");
            	soundPool.play(Asharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Csharp_button = (Button) findViewById(R.id.pianoCsharpkey);
        Csharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("9");
            	soundPool.play(Csharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Dsharp_button = (Button) findViewById(R.id.pianoDsharpkey);
        Dsharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("10");
            	soundPool.play(Dsharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Fsharp_button = (Button) findViewById(R.id.pianoFsharpkey);
        Fsharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("11");
            	soundPool.play(Fsharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        Gsharp_button = (Button) findViewById(R.id.pianoGsharpkey);
        Gsharp_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("12");
            	soundPool.play(Gsharp_tone, 1, 1, 0, 0, 1);
            }

        });
        
        rim_button = (Button) findViewById(R.id.drums_rim_key);
        rim_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("13");
            	soundPool.play(rim_tone, 1, 1, 0, 0, 1);
            }

        });
        
        ride_button = (Button) findViewById(R.id.drums_ride_key);
        ride_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("14");
            	soundPool.play(ride_tone, 1, 1, 0, 0, 1);
            }

        });
        
        crash_button = (Button) findViewById(R.id.drums_crash_key);
        crash_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("15");
            	soundPool.play(crash_tone, 1, 1, 0, 0, 1);
            }

        });
        
        hhopen_button = (Button) findViewById(R.id.drums_hhopen_key);
        hhopen_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("16");
            	soundPool.play(hhopen_tone, 1, 1, 0, 0, 1);
            }

        });
        
        hhped_button = (Button) findViewById(R.id.drums_hhped_key);
        hhped_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("17");
            	soundPool.play(hhped_tone, 1, 1, 0, 0, 1);
            }

        });
        
        hhcl_button = (Button) findViewById(R.id.drums_hhcl_key);
        hhcl_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("18");
            	soundPool.play(hhcl_tone, 1, 1, 0, 0, 1);
            }

        });
        
        rk1_button = (Button) findViewById(R.id.drums_rk1_key);
        rk1_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("19");
            	soundPool.play(rk1_tone, 1, 1, 0, 0, 1);
            }

        });
        
        rk3_button = (Button) findViewById(R.id.drums_rk3_key);
        rk3_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("20");
            	soundPool.play(rk3_tone, 1, 1, 0, 0, 1);
            }

        });
        
        fl_button = (Button) findViewById(R.id.drums_fl_key);
        fl_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("21");
            	soundPool.play(fl_tone, 1, 1, 0, 0, 1);
            }

        });
        
        sn_button = (Button) findViewById(R.id.drums_sn_key);
        sn_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("22");
            	soundPool.play(sn_tone, 1, 1, 0, 0, 1);
            }

        });
        
        kik_button = (Button) findViewById(R.id.drums_kik_key);
        kik_button.setOnClickListener(new View.OnClickListener() {
        	@ Override
            public void onClick(View view) {
                // play tone
        		sendMessage("23");
            	soundPool.play(kik_tone, 1, 1, 0, 0, 1);
            }

        });

// Flute
        fluteAbutton = (Button) findViewById(R.id.fluteakey);
        fluteAbutton.setOnClickListener(new View.OnClickListener() {
            @ Override
            public void onClick(View view) {
                // play tone
            	sendMessage("24");
                soundPool.play(flute_A, 1, 1, 0, 0, 1);
            }

        });
        
        fluteBbutton = (Button) findViewById(R.id.flutebkey);
        fluteBbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("25");
                soundPool.play(flute_B, 1, 1, 0, 0, 1);
            }

        });
        
        fluteCbutton = (Button) findViewById(R.id.fluteckey);
        fluteCbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("26");
                soundPool.play(flute_C, 1, 1, 0, 0, 1);
            }

        });
        
        fluteC2button = (Button) findViewById(R.id.flutec2key);
        fluteC2button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("27");
                soundPool.play(flute_C2, 1, 1, 0, 0, 1);
            }

        });
        
        fluteDbutton = (Button) findViewById(R.id.flutedkey);
        fluteDbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("28");
                soundPool.play(flute_D, 1, 1, 0, 0, 1);
            }

        });
        
        fluteEbutton = (Button) findViewById(R.id.fluteekey);
        fluteEbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("29");
                soundPool.play(flute_E, 1, 1, 0, 0, 1);
            }

        });
        
        fluteFbutton = (Button) findViewById(R.id.flutefkey);
        fluteFbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("30");
                soundPool.play(flute_F, 1, 1, 0, 0, 1);
            }

        });
        
        fluteGbutton = (Button) findViewById(R.id.flutegkey);
        fluteGbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("31");
                soundPool.play(flute_G, 1, 1, 0, 0, 1);
            }

        });
        
        
//        Guitar
        A_button_gtr = (Button) findViewById(R.id.guitarAkey);
        A_button_gtr.setOnClickListener(new View.OnClickListener() {
            @ Override
            public void onClick(View view) {
                // play tone
            	sendMessage("32");
                soundPool.play(A_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        B_button_gtr = (Button) findViewById(R.id.guitarBkey);
        B_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("33");
                soundPool.play(B_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
        
        C2_button_gtr = (Button) findViewById(R.id.guitarC2key);
        C2_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("34");
                soundPool.play(C2_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        C_button_gtr = (Button) findViewById(R.id.guitarCkey);
        C_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("35");
                soundPool.play(C_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        D_button_gtr = (Button) findViewById(R.id.guitarDkey);
        D_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("36");
                soundPool.play(D_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        E_button_gtr = (Button) findViewById(R.id.guitarEkey);
        E_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("37");
                soundPool.play(E_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        F_button_gtr = (Button) findViewById(R.id.guitarFkey);
        F_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
            	sendMessage("38");
                soundPool.play(F_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        G_button_gtr = (Button) findViewById(R.id.guitarGkey);
        G_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
                sendMessage("39");
                soundPool.play(G_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        Asharp_button_gtr = (Button) findViewById(R.id.guitarAsharpkey);
        Asharp_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
                sendMessage("40");
                soundPool.play(Asharp_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        Csharp_button_gtr = (Button) findViewById(R.id.guitarCsharpkey);
        Csharp_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
                sendMessage("41");
                soundPool.play(Csharp_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        Dsharp_button_gtr = (Button) findViewById(R.id.guitarDsharpkey);
        Dsharp_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
                sendMessage("42");
                soundPool.play(Dsharp_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        Fsharp_button_gtr = (Button) findViewById(R.id.guitarFsharpkey);
        Fsharp_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
                sendMessage("43");
                soundPool.play(Fsharp_tone_gtr, 1, 1, 0, 0, 1);
            }

        });
            
        Gsharp_button_gtr = (Button) findViewById(R.id.guitarGsharpkey);
        Gsharp_button_gtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // play tone
                sendMessage("44");
                soundPool.play(Gsharp_tone_gtr, 1, 1, 0, 0, 1);
            }

        });




        if(D) Log.e(TAG, "FINISHED ONCREATE");
    }

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
    
    @Override
    public void onStart() {
        super.onStart();
        if(D) Log.e(TAG, "++ ON START ++");

        // If BT is not on, request that it be enabled.
        // setupChat() will then be called during onActivityResult
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
        // Otherwise, setup the chat session
        } else {
            if (mChatService == null) setupChat();
        }
        if(D) Log.e(TAG, "++ ON START E ++");
    }

    @Override
    public synchronized void onResume() {
        super.onResume();
        if(D) Log.e(TAG, "+ ON RESUME +");

        // Performing this check in onResume() covers the case in which BT was
        // not enabled during onStart(), so we were paused to enable it...
        // onResume() will be called when ACTION_REQUEST_ENABLE activity returns.
        if (mChatService != null) {
            // Only if the state is STATE_NONE, do we know that we haven't started already
            if (mChatService.getState() == BluetoothChatService.STATE_NONE) {
              // Start the Bluetooth chat services
              mChatService.start();
            }
        }
        if(D) Log.e(TAG, "++ ON RESUME E ++");
    }

    private void setupChat() {
        Log.d(TAG, "setupChat()");

        // Initialize the array adapter for the conversation thread
        mConversationArrayAdapter = new ArrayAdapter<String>(this, R.layout.message);
        mConversationView = (ListView) findViewById(R.id.in);
        mConversationView.setAdapter(mConversationArrayAdapter);

        // Initialize the compose field with a listener for the return key
        mOutEditText = (EditText) findViewById(R.id.edit_text_out);
        mOutEditText.setOnEditorActionListener(mWriteListener);

        // Initialize the send button with a listener that for click events
        mSendButton = (Button) findViewById(R.id.button_send);
        mSendButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Send a message using content of the edit text widget
                TextView view = (TextView) findViewById(R.id.edit_text_out);
                String message = view.getText().toString();
                sendMessage(message);
            }
        });

        // Initialize the BluetoothChatService to perform bluetooth connections
        mChatService = new BluetoothChatService(this, mHandler);

        // Initialize the buffer for outgoing messages
        mOutStringBuffer = new StringBuffer("");
        if(D) Log.e(TAG, "setupChat() E");
    }

    @Override
    public synchronized void onPause() {
        super.onPause();
        if(D) Log.e(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        if(D) Log.e(TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stop the Bluetooth chat services
        if (mChatService != null) mChatService.stop();
        if(D) Log.e(TAG, "--- ON DESTROY ---");
    }

    private void ensureDiscoverable() {
        if(D) Log.d(TAG, "ensure discoverable");
        if (mBluetoothAdapter.getScanMode() !=
            BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoverableIntent);
        }
    }

    /**
     * Sends a message.
     * @param message  A string of text to send.
     */
    private void sendMessage(String message) {
        // Check that we're actually connected before trying anything
        if (mChatService.getState() != BluetoothChatService.STATE_CONNECTED) {
            Toast.makeText(this, R.string.not_connected, Toast.LENGTH_SHORT).show();
            return;
        }

        // Check that there's actually something to send
        if (message.length() > 0) {
            // Get the message bytes and tell the BluetoothChatService to write
            byte[] send = message.getBytes();
            mChatService.write(send);
            
            // Reset out string buffer to zero and clear the edit text field
            mOutStringBuffer.setLength(0);
            mOutEditText.setText(mOutStringBuffer);
        }
    }

    // The action listener for the EditText widget, to listen for the return key
    private TextView.OnEditorActionListener mWriteListener =
        new TextView.OnEditorActionListener() {
        public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
            // If the action is a key-up event on the return key, send the message
            if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_UP) {
                String message = view.getText().toString();
                sendMessage(message);
            }
            if(D) Log.i(TAG, "END onEditorAction");
            return true;
        }
    };

    // The Handler that gets information back from the BluetoothChatService
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MESSAGE_STATE_CHANGE:
                if(D) Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
                switch (msg.arg1) {
                case BluetoothChatService.STATE_CONNECTED:
                    //mTitle.setText(R.string.title_connected_to);
                    //mTitle.append(mConnectedDeviceName);
                    mConversationArrayAdapter.clear();
                    break;
                case BluetoothChatService.STATE_CONNECTING:
                    //mTitle.setText(R.string.title_connecting);
                    break;
                case BluetoothChatService.STATE_LISTEN:
                case BluetoothChatService.STATE_NONE:
                    //mTitle.setText(R.string.title_not_connected);
                    break;
                }
                break;
            case MESSAGE_WRITE:
                byte[] writeBuf = (byte[]) msg.obj;
                // construct a string from the buffer
                String writeMessage = new String(writeBuf);
                //mConversationArrayAdapter.add("Me:  " + writeMessage);
                if(D) Log.e(TAG, "Sent: "+Integer.parseInt(writeMessage));
                try {
                    synchronized(this){
                        wait(20);
                    }
                }
                catch(InterruptedException ex){                    
                }
                playsound(Integer.parseInt(writeMessage));
                break;
            case MESSAGE_READ:
                byte[] readBuf = (byte[]) msg.obj;
                // construct a string from the valid bytes in the buffer
                String readMessage = new String(readBuf, 0, msg.arg1);
                //mConversationArrayAdapter.add(mConnectedDeviceName+":  " + readMessage);
                if(D) Log.e(TAG, "Received: "+Integer.parseInt(readMessage));
               
                playsound(Integer.parseInt(readMessage));
                break;
            case MESSAGE_DEVICE_NAME:
                // save the connected device's name
                mConnectedDeviceName = msg.getData().getString(DEVICE_NAME);
                Toast.makeText(getApplicationContext(), "Connected to "
                               + mConnectedDeviceName, Toast.LENGTH_SHORT).show();
                break;
            case MESSAGE_TOAST:
                Toast.makeText(getApplicationContext(), msg.getData().getString(TOAST),
                               Toast.LENGTH_SHORT).show();
                break;
            }
        }
    };

    public void playsound(int sound){
    	switch(sound){
    	case A_TONE:
    		soundPool.play(A_tone, 1, 1, 0, 0, 1);
    		break;
    	case B_TONE:
    		soundPool.play(B_tone, 1, 1, 0, 0, 1);
    		break;
    	case C_TONE:
    		soundPool.play(C_tone, 1, 1, 0, 0, 1);
    		break;
    	case D_TONE:
    		soundPool.play(D_tone, 1, 1, 0, 0, 1);
    		break;
    	case E_TONE:
    		soundPool.play(E_tone, 1, 1, 0, 0, 1);
    		break;
    	case F_TONE:
    		soundPool.play(F_tone, 1, 1, 0, 0, 1);
    		break;
    	case G_TONE:
    		soundPool.play(G_tone, 1, 1, 0, 0, 1);
    		break;
    	case A_SHARP_TONE:
    		soundPool.play(Asharp_tone, 1, 1, 0, 0, 1);
    		break;
    	case C_SHARP_TONE:
    		soundPool.play(Csharp_tone, 1, 1, 0, 0, 1);
    		break;
    	case D_SHARP_TONE:
    		soundPool.play(Dsharp_tone, 1, 1, 0, 0, 1);
    		break;
    	case F_SHARP_TONE:
    		soundPool.play(Fsharp_tone, 1, 1, 0, 0, 1);
    		break;
    	case G_SHARP_TONE:
    		soundPool.play(Gsharp_tone, 1, 1, 0, 0, 1);
    		break;
    	case RIM_TONE:
    		soundPool.play(rim_tone, 1, 1, 0, 0, 1);
    		break;
    	case RIDE_TONE:
    		soundPool.play(ride_tone, 1, 1, 0, 0, 1);
    		break;
    	case CRASH_TONE:
    		soundPool.play(crash_tone, 1, 1, 0, 0, 1);
    		break;
    	case HHOPEN_TONE:
    		soundPool.play(hhopen_tone, 1, 1, 0, 0, 1);
    		break;
    	case HHPED_TONE:
    		soundPool.play(hhped_tone, 1, 1, 0, 0, 1);
    		break;
    	case HHCL_TONE:
    		soundPool.play(hhcl_tone, 1, 1, 0, 0, 1);
    		break;
    	case RK1_TONE:
    		soundPool.play(rk1_tone, 1, 1, 0, 0, 1);
    		break;
    	case RK3_TONE:
    		soundPool.play(rk3_tone, 1, 1, 0, 0, 1);
    		break;
    	case FL_TONE:
    		soundPool.play(fl_tone, 1, 1, 0, 0, 1);
    		break;
    	case SN_TONE:
    		soundPool.play(sn_tone, 1, 1, 0, 0, 1);
    		break;
    	case KIK_TONE:
    		soundPool.play(kik_tone, 1, 1, 0, 0, 1);
    		break;

        // Flute
        case FLUTE_A: // 24
            soundPool.play(flute_A, 1, 1, 0, 0, 1);
            break;
        case FLUTE_B: // 25
            soundPool.play(flute_B, 1, 1, 0, 0, 1);
            break;
        case FLUTE_C: // 26
            soundPool.play(flute_C, 1, 1, 0, 0, 1);
            break;
        case FLUTE_D: // 27
            soundPool.play(flute_D, 1, 1, 0, 0, 1);
            break;
        case FLUTE_E: // 28
            soundPool.play(flute_E, 1, 1, 0, 0, 1);
            break;
        case FLUTE_F: // 29
            soundPool.play(flute_F, 1, 1, 0, 0, 1);
            break;
        case FLUTE_G: // 30
            soundPool.play(flute_G, 1, 1, 0, 0, 1);
            break;
        case FLUTE_C2: // 31
            soundPool.play(flute_C2, 1, 1, 0, 0, 1);
            break;
            
        // Guitar
        case A_TONE_GTR: // 32
            soundPool.play(A_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case B_TONE_GTR: // 33
            soundPool.play(B_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case C_TONE_GTR: // 34
            soundPool.play(C_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case C2_TONE_GTR: // 35
            soundPool.play(C2_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case D_TONE_GTR: // 36
            soundPool.play(D_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case E_TONE_GTR: // 37
            soundPool.play(E_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case F_TONE_GTR: // 38
            soundPool.play(F_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case G_TONE_GTR: // 39
            soundPool.play(G_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case ASHARP_TONE_GTR: // 40
            soundPool.play(Asharp_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case CSHARP_TONE_GTR: // 41
            soundPool.play(Csharp_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case DSHARP_TONE_GTR: // 42
            soundPool.play(Dsharp_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case FSHARP_TONE_GTR: // 43
            soundPool.play(Fsharp_tone_gtr, 1, 1, 0, 0, 1);
            break;
        case GSHARP_TONE_GTR: // 44
            soundPool.play(Gsharp_tone_gtr, 1, 1, 0, 0, 1);
            break;

    	}
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(D) Log.d(TAG, "onActivityResult " + resultCode);
        switch (requestCode) {
        case REQUEST_CONNECT_DEVICE:
            // When DeviceListActivity returns with a device to connect
            if (resultCode == Activity.RESULT_OK) {
                // Get the device MAC address
                String address = data.getExtras()
                                     .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
                // Get the BLuetoothDevice object
                BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
                // Attempt to connect to the device
                mChatService.connect(device);
            }
            break;
        case REQUEST_ENABLE_BT:
            // When the request to enable Bluetooth returns
            if (resultCode == Activity.RESULT_OK) {
                // Bluetooth is now enabled, so set up a chat session
                setupChat();
            } else {
                // User did not enable Bluetooth or an error occured
                Log.d(TAG, "BT not enabled");
                Toast.makeText(this, R.string.bt_not_enabled_leaving, Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.scan:
            // Launch the DeviceListActivity to see devices and do scan
            Intent serverIntent = new Intent(this, DeviceListActivity.class);
            startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE);
            return true;
        case R.id.discoverable:
            // Ensure this device is discoverable by others
            ensureDiscoverable();
            return true;
        }
        return false;
    }

}