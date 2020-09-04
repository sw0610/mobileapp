package com.example.jsonparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
        List<Weather>weatherList =new ArrayList<Weather>();

        public ConnectThread(String inStr){
            urlStr = inStr;
        }

        public void run(){

            try{
                Request request = new Request.Builder()
                        .url(urlStr)
                        .build();

                Response response = client.newCall(request).execute();

                Gson gson=new Gson();

                Type listType = new TypeToken<ArrayList<Weather>>() {}.getType();
                weatherList = gson.fromJson(response.body().string(),listType);

                Log.d("MainActivity", "onCreate: "+ weatherList.toString());

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        txtMsg.setText(weatherList.toString());
                    }
                });
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
