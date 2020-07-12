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
import android.widget.Toast;

import java.util.Locale;

public class givenmoney extends AppCompatActivity {

    ImageButton home, info, cancel,moneypaidTxtspeaker;
    static  int count2=0;
    TextToSpeech mTTS;
    String cc=null;
    TextView counttxt2;
    Button okbtn2,clearbtn2;
    ImageButton tk2,tk5,tk10,tk20,tk50,tk100,tk500,tk1000,onetkcoin,twotkcoin,fivetkcoin,speackergivenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_givenmoney);

        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);
        counttxt2= (TextView) findViewById(R.id.counttxt2);
        okbtn2=(Button) findViewById(R.id.okbtn2);
        clearbtn2=(Button) findViewById(R.id.clearbtn2);
        tk2=(ImageButton) findViewById(R.id.tk22);
        tk5=(ImageButton) findViewById(R.id.tk52);
        tk10=(ImageButton) findViewById(R.id.tk102);
        tk20=(ImageButton) findViewById(R.id.tk202);
        tk50=(ImageButton) findViewById(R.id.tk502);
        tk100=(ImageButton) findViewById(R.id.tk1002);
        tk500=(ImageButton) findViewById(R.id.tk5002);
        tk1000=(ImageButton) findViewById(R.id.tk10002);
        onetkcoin=(ImageButton) findViewById(R.id.onetkcoin2);
        twotkcoin=(ImageButton) findViewById(R.id.twotkcoin2);
        fivetkcoin=(ImageButton) findViewById(R.id.fivetkcoin2);
        speackergivenBtn=(ImageButton) findViewById(R.id.speackergivenBtn);
        moneypaidTxtspeaker=(ImageButton) findViewById(R.id.moneypaidTxt1speaker);

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
                count2= count2+1;
                counttxt2.setText(""+count2);
            }
        });


        twotkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+2;
                counttxt2.setText(""+count2);
            }
        });

        fivetkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2=count2+5;
                counttxt2.setText(""+count2);
            }
        });


        tk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+2;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        tk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+5;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        tk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+10;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        tk20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+20;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        tk50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+50;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        tk100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+100;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        tk500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+500;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        tk1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2= count2+1000;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });

        clearbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count2=0;
                cc=Integer.toString(count2);
                counttxt2.setText(""+count2);
            }
        });


        okbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),cc,Toast.LENGTH_LONG).show();
                Intent i= new Intent(givenmoney.this,returnmoney.class);
                i.putExtra("giventk",cc);
                startActivity(i);
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
                        speackergivenBtn.setEnabled(true);
                        moneypaidTxtspeaker.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


                speackergivenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        moneypaidTxtspeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1();
            }
        });


    }

    private void speak() {


        String text = counttxt2.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak1() {


        String text ="Select the money you have paid by clicking the images in scrollable box";
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

        Intent intent5 = new Intent(givenmoney.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(givenmoney.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }


}
