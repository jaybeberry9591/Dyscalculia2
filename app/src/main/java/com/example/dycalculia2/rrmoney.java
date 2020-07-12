package com.example.dycalculia2;

import android.content.Intent;
import android.media.Image;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class rrmoney extends AppCompatActivity {

    ImageButton home, info, cancel,rrcountspeaker,rrtxtspeaker;
    TextView rrcounttxt2,rrtxt2;
    Button rrokbtn;
    ImageButton rrtk2,rrtk5,rrtk10,rrtk20,rrtk50,rrtk100,rrtk500,rrtk1000,rronetkcoin,rrtwotkcoin,rrfivetkcoin;
    ImageButton speackerrrcounttxt2Btn,speackerrrtxt2Btn;
    int rrcount=0;
    TextToSpeech mTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrmoney);

        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);
        rrcountspeaker=(ImageButton) findViewById(R.id.rrcountspeaker);
        rrtxtspeaker=(ImageButton) findViewById(R.id.rrtxtspeaker);

        rrcounttxt2= (TextView) findViewById(R.id.rrcounttxt2);
        rrtxt2=(TextView)findViewById(R.id.rrtxt2);
        rrtk2=(ImageButton) findViewById(R.id.rrtk2);
        rrtk5=(ImageButton) findViewById(R.id.rrtk5);
        rrtk10=(ImageButton) findViewById(R.id.rrtk10);
        rrtk20=(ImageButton) findViewById(R.id.rrtk20);
        rrtk50=(ImageButton) findViewById(R.id.rrtk50);
        rrtk100=(ImageButton) findViewById(R.id.rrtk100);
        rrtk500=(ImageButton) findViewById(R.id.rrtk500);
        rrtk1000=(ImageButton) findViewById(R.id.rrtk1000);
        rronetkcoin=(ImageButton) findViewById(R.id.rronetkcoin);
        rrtwotkcoin=(ImageButton) findViewById(R.id.rrtwotkcoin);
        rrfivetkcoin=(ImageButton) findViewById(R.id.rrfivetkcoin);
        speackerrrcounttxt2Btn=(ImageButton)findViewById(R.id.speackerrrcounttxt2Btn);
        speackerrrtxt2Btn=(ImageButton) findViewById(R.id.speackerrrtxt2Btn);
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




        final String sss=getIntent().getStringExtra("difftk");
        rrtxt2.setText(sss);



        rronetkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+1;
                rrcounttxt2.setText(""+rrcount);
            }
        });


        rrtwotkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+2;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrfivetkcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount=rrcount+5;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+2;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+5;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+10;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+20;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+50;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+100;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+500;
                rrcounttxt2.setText(""+rrcount);
            }
        });

        rrtk1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rrcount= rrcount+1000;
                rrcounttxt2.setText(""+rrcount);
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
                        speackerrrcounttxt2Btn.setEnabled(true);
                        speackerrrtxt2Btn.setEnabled(true);
                        rrcountspeaker.setEnabled(true);
                        rrtxtspeaker.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        speackerrrcounttxt2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1();
            }
        });
        speackerrrtxt2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak2();
            }
        });
        rrcountspeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak3();
            }
        });
        rrtxtspeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak4();
            }
        });

    }

    private void speak1() {


        String text = rrcounttxt2.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    private void speak2() {


        String text = rrtxt2.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak3() {


        String text = "Select the images of the money you have received";
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak4() {


        String text = "the amount you should get";
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

        Intent intent5 = new Intent(rrmoney.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(rrmoney.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }

}
