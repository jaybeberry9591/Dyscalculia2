package com.example.dycalculia2;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {


    TextToSpeech mTTS;

    GridLayout mainGrid;
    ImageView calculationBtn,countBtn,transposeBtn,moneyBtn;
    TextView calculationtxt,counttxt,transposetxt,monetarytxt;

    ImageButton calspeakerbtn,conspeakerbtn,traspeakerbtn,monspeakerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mainGrid=(GridLayout) findViewById(R.id.mainGrid);
        calculationBtn=(ImageView) findViewById(R.id.calculatorBtn);
        countBtn=(ImageView)findViewById(R.id.countBtn);
        transposeBtn=(ImageView) findViewById(R.id.transposeBtn);
        moneyBtn=(ImageView) findViewById(R.id.monetaryBtn);

        calspeakerbtn=(ImageButton) findViewById(R.id.calspeakerbtn);
        conspeakerbtn=(ImageButton) findViewById(R.id.couspeakerbtn);
        traspeakerbtn=(ImageButton) findViewById(R.id.traspeakerbtn);
        monspeakerbtn=(ImageButton) findViewById(R.id.monspeakerbtn);

        calculationtxt=(TextView) findViewById(R.id.calculationtxt);
        counttxt=(TextView) findViewById(R.id.counttxt);
        transposetxt=(TextView) findViewById(R.id.transposetxt);
        monetarytxt=(TextView) findViewById(R.id.monetarytxt);


        calculationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal();
            }
        });
        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cou();
            }
        });
        transposeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tra();
            }
        });
        moneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mon();
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
                        calspeakerbtn.setEnabled(true);
                        conspeakerbtn.setEnabled(true);
                        traspeakerbtn.setEnabled(true);
                        monspeakerbtn.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        calspeakerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        conspeakerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1();
            }
        });
        traspeakerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak2();
            }
        });
        monspeakerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak3();
            }
        });


    //    setSingleEvent(mainGrid);


    }

    void speak(){

        String text = calculationtxt.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    void speak1(){

        String text = counttxt.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    void speak2(){

        String text = transposetxt.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    void speak3(){

        String text = monetarytxt.getText().toString().trim();
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



//    private  void setSingleEvent(GridLayout mainGrid){
//
//        for(int i=0;i<mainGrid.getChildCount();i++){
//            CardView cardView=(CardView) mainGrid.getChildAt(i);
//            final int finalI = i;
//            cardView.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public  void onClick(View view){
//                    if(finalI==0){
//                        if(calculationBtn.isPressed()){
//                            Intent intent= new Intent(HomeActivity.this,calculationactivity.class);
//                            startActivity(intent);
//                        }
//                        else{
//
//                            Toast.makeText(getApplicationContext(),"Press the Image",Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                    else if(finalI==1){
//                        Intent intent= new Intent(HomeActivity.this,transpose.class);
//                        startActivity(intent);
//                    }
//
//                    else if(finalI==2){
//                        Intent intent= new Intent(HomeActivity.this,countactivity.class);
//                        startActivity(intent);
//                    }
//
//
//                    else if(finalI==3){
//                        Intent intent= new Intent(HomeActivity.this,Mainmoney.class);
//                        startActivity(intent);
//                    }
//
//
//
//                }
//
//            });
//
//        }
//
//
//    }


    public  void cal(){
        Intent intent= new Intent(HomeActivity.this,calculationactivity.class);
                          startActivity(intent);

    }

    public  void cou(){

        Intent intent= new Intent(HomeActivity.this,countactivity.class);
                       startActivity(intent);
    }

    public void tra(){

        Intent intent= new Intent(HomeActivity.this,transpose.class);
                     startActivity(intent);
    }

    public  void mon(){
        Intent intent= new Intent(HomeActivity.this,Mainmoney.class);
        startActivity(intent);

    }


}
