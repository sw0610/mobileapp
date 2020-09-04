package com.example.okhttpclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText input01;
    TextView txtMsg;

    public static String defaultURl = "https://goo.gl/eIXu9l";

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input01 = (EditText)findViewById(R.id.input01);
        input01.setText(defaultURl);

        txtMsg = (TextView)findViewById(R.id.txtMsg);

        //버튼 이벤트 처리
        Button requestBtn =(Button)findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlStr = input01.getText().toString();

                ConnectThread thread = new ConnectThread(urlStr);
                thread.start();
            }
        });

    }
    class ConnectThread extends Thread {
        OkHttpClient client = new OkHttpClient();
        String urlStr;

        public ConnectThread(String inStr){
            urlStr = inStr;
        }

        public void run(){

            try{
                Request request = new Request.Builder()
                        .url(urlStr)
                        .build();

                Response response = client.newCall(request).execute();
                final String output = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        txtMsg.setText(output);
                    }
                });
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
