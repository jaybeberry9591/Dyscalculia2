package com.example.dycalculia2;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class calculationactivity extends AppCompatActivity {

    TextToSpeech mTTS;
    ImageButton home, info, cancel,speakerbtn,calculationTxt1speaker,Txtspeaker,rTxtspeaker;
    TextView calculationTxt1,Txt,rTxt;
    ImageView mic;
    TextView resulttxt,inputtxt;
    int num,num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculationactivity);
        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);
        mic=(ImageView) findViewById(R.id.microphone);
        inputtxt=(TextView) findViewById(R.id.inpuyTxt);
        resulttxt=(TextView) findViewById(R.id.resultTxt);
        speakerbtn=(ImageButton) findViewById(R.id.speackerBtn);

        calculationTxt1speaker=(ImageButton)findViewById(R.id.calculationTxt1speaker);
        Txtspeaker=(ImageButton) findViewById(R.id.Txtspeaker);
        rTxtspeaker=(ImageButton) findViewById(R.id.rTxtspeaker);

        calculationTxt1=(TextView) findViewById(R.id.calculationTxt1);
        Txt=(TextView) findViewById(R.id.Txt);
        rTxt=(TextView) findViewById(R.id.rTxt);

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
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpeech();

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
                        speakerbtn.setEnabled(true);
                        calculationTxt1speaker.setEnabled(true);
                        Txtspeaker.setEnabled(true);
                        rTxtspeaker.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        speakerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        calculationTxt1speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1();
            }
        });
        Txtspeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak2();
            }
        });
        rTxtspeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak3();
            }
        });


    }

    private void speak() {


        String text = resulttxt.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak1() {


        String text ="Give input by pressing mic icon while numbers are minimum two digit";
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak2() {


        String text ="see your input in the below textbox";
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    private void speak3() {


        String text = "see your result in the below textbox";
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

        Intent intent5 = new Intent(calculationactivity.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(calculationactivity.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }

    void getSpeech(){


        String mom=null;
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    inputtxt.setText(result.get(0));
                }
                break;
        }

        String s = inputtxt.getText().toString().trim();
        Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d+?");
        List<String> numbers = new ArrayList<String>();
        Matcher m = p.matcher(s);
        while (m.find()) {
            numbers.add(m.group());
        }


        if (s.contains("cosine")) {

            String con = numbers.get(0);
            num = Integer.parseInt(con);
            Double i = new Double(num);
            i = Math.toRadians(i);
            double x = Math.cos(i);
            String z = new DecimalFormat("##.###").format(x);
            resulttxt.setText(z);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        } else if (s.contains("sine")) {

            String con = numbers.get(0);
            num = Integer.parseInt(con);
            Double i = new Double(num);
            i = Math.toRadians(i);
            double x = Math.sin(i);
            String z = new DecimalFormat("##.###").format(x);
            resulttxt.setText(z);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        } else if (s.contains("tangent")) {

            String con = numbers.get(0);
            num = Integer.parseInt(con);
            Double i = new Double(num);
            i = Math.toRadians(i);
            double x = Math.tan(i);
            String z = new DecimalFormat("##.###").format(x);
            resulttxt.setText(z);
            //  Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        } else if (s.contains("width") && s.contains("height") && s.contains("area")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            num = num1 * num2;
            resulttxt.setText("" + num);
            // Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if (s.contains("more") && s.contains("many")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            num = num1 + num2;
            resulttxt.setText("" + num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if (s.contains("return")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            num = num1 - num2;
            resulttxt.setText("" + num);
            //Toast.makeText(getApplicationContext(),Math.abs(num)+"",Toast.LENGTH_LONG).show();
        }

        else if (s.contains("multiply")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            num = num1 * num2;
            resulttxt.setText("" + num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if (s.contains("add") || s.contains("plus")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            num = num1 + num2;
            resulttxt.setText("" + num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        } else if (s.contains("subtract") || s.contains("minus")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            num = num1 - num2;
            resulttxt.setText("" + num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        } else if (s.contains("divide")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            if (num2 == 0) {
                resulttxt.setText("Can't Divide by Zero");
                //Toast.makeText(getApplicationContext(),"Can't divide by zero",Toast.LENGTH_LONG).show();
            } else {
                num = num1 / num2;
                resulttxt.setText("" + num);
                //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
            }

        } else if (s.contains("discount")) {
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            Double i1 = new Double(num1);
            Double i2 = new Double(num2);
            Double x = i1 - (i1 * i2 / 100);
            String z = new DecimalFormat("##.###").format(x);
            resulttxt.setText(z);
            // Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        } else if (s.contains("cost") && (s.contains("vat")||s.contains("VAT"))) {
            //  Toast.makeText(getApplicationContext(),"Inside vat",Toast.LENGTH_LONG).show();
            String con1 = numbers.get(0);
            String con2 = numbers.get(1);
            num1 = Integer.parseInt(con1);
            num2 = Integer.parseInt(con2);
            Double i1 = new Double(num1);
            Double i2 = new Double(num2);
            Double x = i1 + (i1 * (i2 / 100));
            String z = new DecimalFormat("##.###").format(x);
            resulttxt.setText(z);
            // Toast.makeText(getApplicationContext(),con1+" "+con2,Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();


        } else {

            resulttxt.setText(numbers.get(0));
        }


    }
}
