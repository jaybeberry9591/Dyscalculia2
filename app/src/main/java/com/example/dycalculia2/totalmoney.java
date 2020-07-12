package com.example.dycalculia2;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class totalmoney extends AppCompatActivity {

    ImageButton home, info, cancel,Txtspeaker;
    TextToSpeech mTTS;
    int count=0;
    String c=null;
    TextView counttxt;
    Button clearbtn;
    ImageButton speackercounttxt2btn;
    ImageButton tk2,tk5,tk10,tk20,tk50,tk100,tk500,tk1000,onetkcoin,twotkcoin,fivetkcoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalmoney);
        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);
        Txtspeaker=(ImageButton) findViewById(R.id.Txtspeaker);

        counttxt= (TextView) findViewById(R.id.counttxt);
        clearbtn=(Button) findViewById(R.id.clearbtn);
        tk2=(ImageButton) findViewById(R.id.tk2);
        tk5=(ImageButton) findViewById(R.id.tk5);
        tk10=(ImageButton) findViewById(R.id.tk10);
        tk20=(ImageButton) findViewById(R.id.tk20);
        tk50=(ImageButton) findViewById(R.id.tk50);
        tk100=(ImageButton) findViewById(R.id.tk100);
        tk500=(ImageButton) findViewById(R.id.tk500);
        tk1000=(ImageButton) findViewById(R.id.tk1000);
        onetkcoin=(ImageButton) findViewById(R.id.onetkcoin);
        twotkcoin=(ImageButton) findViewById(R.id.twotkcoin);
        fivetkcoin=(ImageButton) findViewById(R.id.fivetkcoin);
        speackercounttxt2btn=(ImageButton) findViewById(R.id.speackercounttxt2Btn);
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

        onetkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+1;
                counttxt.setText(""+count);
            }
        });


        twotkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+2;
                counttxt.setText(""+count);
            }
        });


        fivetkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+5;
                counttxt.setText(""+count);
            }
        });



        tk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+2;
                counttxt.setText(""+count);
            }
        });

        tk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+5;
                counttxt.setText(""+count);
            }
        });

        tk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+10;
                counttxt.setText(""+count);
            }
        });

        tk20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+20;
                counttxt.setText(""+count);
            }
        });

        tk50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+50;
                counttxt.setText(""+count);
            }
        });

        tk100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+100;
                counttxt.setText(""+count);
            }
        });

        tk500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+500;
                counttxt.setText(""+count);
            }
        });

        tk1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count= count+1000;
                counttxt.setText(""+count);
            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                counttxt.setText("SELECT THE MONEY");
            }
        });


        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        speackercounttxt2btn.setEnabled(true);
                        Txtspeaker.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        speackercounttxt2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        Txtspeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1();
            }
        });


    }

    private void speak() {


        String text = counttxt.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak1() {


        String text = "By clicking on the images calculate the total amount of money";
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }





    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }

    void gohomeActivity(){

        Intent intent5 = new Intent(totalmoney.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(totalmoney.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }


}
