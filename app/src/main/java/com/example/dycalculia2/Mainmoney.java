package com.example.dycalculia2;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Locale;

public class Mainmoney extends AppCompatActivity {

    TextToSpeech mTTS;
    Button checkmoney,countmoney;
    ImageButton home, info, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmoney);

        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);
        //mainmoneyTxt1speaker=(ImageButton) findViewById(R.id.moneypaidTxt1speaker);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohomeActivity();

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goinfoActivity();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelprogram();

            }
        });

        checkmoney=(Button) findViewById(R.id.checkmoney);
        countmoney=(Button) findViewById(R.id.countmoney);


//        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if (status == TextToSpeech.SUCCESS) {
//                    int result = mTTS.setLanguage(Locale.ENGLISH);
//
//                    if (result == TextToSpeech.LANG_MISSING_DATA
//                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                        Log.e("TTS", "Language not supported");
//                    } else {
//                        mainmoneyTxt1speaker.setEnabled(true);
//
//                    }
//                } else {
//                    Log.e("TTS", "Initialization failed");
//                }
//            }
//        });
//
//
//        mainmoneyTxt1speaker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                speak();
//            }
//        });


        countmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tm();
            }
        });

        checkmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm();
            }
        });
    }

    void tm(){

        Intent i=new Intent(Mainmoney.this,totalmoney.class);
        startActivity(i);
    }

    void cm(){

        Intent i1= new Intent(Mainmoney.this,givenmoney.class);
        startActivity(i1);
    }

//    private void speak() {
//
//
//        String text ="Click on the required operation";
//        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        if (mTTS != null) {
//            mTTS.stop();
//            mTTS.shutdown();
//        }
//
//        super.onDestroy();
//    }
//

    void gohomeActivity(){

        Intent intent5 = new Intent(Mainmoney.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(Mainmoney.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }


}
