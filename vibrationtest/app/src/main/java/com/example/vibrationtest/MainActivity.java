package com.example.vibrationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTv;
    Button mBtn;

    //boolean cont;
    Thread mThread;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibration_test);

        mTv= (TextView)findViewById(R.id.textView1);
        mBtn=(Button)findViewById(R.id.button1);
    }


    public void mOnclick(View v) {
        String txt = mBtn.getText().toString();

        if (txt.equals("진동시작")) {
            mBtn.setText("멈춤");

            mThread = new Thread(new Runnable() {

                int offset = 10;

                @Override
                public void run() {
                    while (Thread.currentThread() == mThread) {
                        //실행 코드가 담긴 Runnable 객체 생성
                        Runnable callback = new Runnable() {
                            @Override
                            public void run() {
                                //Log.v("MainActivity", "" + mTv.getX());

                                mTv.setX(mTv.getX() + offset);

                            }
                        };

                        //메시지 객체 생성, 생성시 Runnable 객체를 인수로 전달
                        Message msg = Message.obtain(mHandler, callback);

                        //핸들러를 통해 메시지를 메시지 큐로 보냄
                        mHandler.sendMessage(msg);

                        offset = -offset;

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }

                    }
                }
            });
            mThread.start();

        } else {
            mBtn.setText("진동시작");
            mThread=null;
        }
    }
}

