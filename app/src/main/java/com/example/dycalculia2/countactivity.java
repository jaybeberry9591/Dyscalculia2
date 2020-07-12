package com.example.dycalculia2;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class countactivity extends AppCompatActivity {

    ImageButton home, info, cancel;
    TextToSpeech mTTS;
    EditText mEditText;
    ImageButton mButtonSpeak,countTxt1speaker,countresultTxt1speaker;
    TextView resultText2,countTxt1,countresultTxt1;
    int num,num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countactivity);

        home=(ImageButton) findViewById(R.id.homebtn2);
        info=(ImageButton) findViewById(R.id.infobtn2);
        cancel=(ImageButton) findViewById(R.id.cancelbtn2);
        mButtonSpeak=(ImageButton) findViewById(R.id.speackerBtn);
        mEditText=(EditText) findViewById(R.id.edcount);
        resultText2=(TextView) findViewById(R.id.resultTxt2);

        countresultTxt1=(TextView) findViewById(R.id.countresultTxt1);
        countTxt1=(TextView) findViewById(R.id.countTxt1);

        countresultTxt1speaker=(ImageButton) findViewById(R.id.countresutlTxt1speaker);
        countTxt1speaker=(ImageButton) findViewById(R.id.countTxt1speaker);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohomeActivity1();

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goinfoActivity1();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelprogram1();

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
                        mButtonSpeak.setEnabled(true);
                        countresultTxt1speaker.setEnabled(true);
                        countTxt1speaker.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        countTxt1speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak1();
            }
        });
        countresultTxt1speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak2();
            }
        });

    }


    private void speak() {
        String n= null;
        String substring=null;
        String s = mEditText.getText().toString().trim();
        Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d+?");
        List<String> numbers = new ArrayList<String>();
        Matcher m = p.matcher(s);
        while (m.find()) {
            numbers.add(m.group());
        }


        if(s.contains("cosine")){

            String con=numbers.get(0);
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.cos(i);
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("sine")){

            String con=numbers.get(0);
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.sin(i);
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("tangent")){

            String con=numbers.get(0);
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.tan(i);
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
            //  Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }


        else if(s.contains("width") && s.contains("height") && s.contains("area")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1*num2;
            resultText2.setText(""+num);
            // Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if(s.contains("more") && s.contains("many")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1+num2;
            resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }


        else if(s.contains("return")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1-num2;
            resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),Math.abs(num)+"",Toast.LENGTH_LONG).show();
        }


        else if(s.contains("multiply")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1*num2;
            resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if(s.contains("add") || s.contains("plus")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1+num2;
            resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if(s.contains("subtract") || s.contains("minus")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            num=num1-num2;
            resultText2.setText(""+num);
            //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
        }

        else if(s.contains("divide")){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            if(num2==0){
                resultText2.setText("Can't Divide by Zero");
                //Toast.makeText(getApplicationContext(),"Can't divide by zero",Toast.LENGTH_LONG).show();
            }
            else{
                num=num1/num2;
                resultText2.setText(""+num);
                //Toast.makeText(getApplicationContext(),num+"",Toast.LENGTH_LONG).show();
            }

        }

        else if(s.contains("discount") ){
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            Double i1=new Double(num1);
            Double i2=new Double(num2);
            Double x=i1-(i1*i2/100);
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
            // Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("cost")&& s.contains("vat")){
            //  Toast.makeText(getApplicationContext(),"Inside vat",Toast.LENGTH_LONG).show();
            String con1=numbers.get(0);
            String con2=numbers.get(1);
            num1=Integer.parseInt(con1);
            num2= Integer.parseInt(con2);
            Double i1=new Double(num1);
            Double i2=new Double(num2);
            Double x=i1+(i1*(i2/100));
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
            // Toast.makeText(getApplicationContext(),con1+" "+con2,Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();


        }

        else{

            resultText2.setText(numbers.get(0));
        }



        String text = resultText2.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak1() {


        String text ="give your input in by typing in the white textbox";
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void speak2() {


        String text ="see your result in the below textbox";
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

    void gohomeActivity1(){

        Intent intent5 = new Intent(countactivity.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity1(){

        Intent intent=new Intent(countactivity.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram1(){

        finish();
        moveTaskToBack(true);
    }

}
