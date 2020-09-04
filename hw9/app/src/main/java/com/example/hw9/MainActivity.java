    package com.example.hw9;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.os.Handler;
    import android.os.Message;
    import android.os.SystemClock;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        TextView mTv;


        Button mBtn_s;
        Button mBtn_p;
        Button mBtn_r;
        Thread mThread;

        Handler mHandler=new Handler();
        boolean isRunning=true;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.hw9);

            mTv = (TextView)findViewById(R.id.tv1);

            mBtn_s= (Button)findViewById(R.id.b_start);
            mBtn_p= (Button)findViewById(R.id.b_pause);
            mBtn_r= (Button)findViewById(R.id.b_reset);


        }

        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                int mSec = msg.arg1 % 10;
                int sec = (msg.arg1 / 100)%60;
                int min = (msg.arg1/100)/60;
                String result = String.format("%02d:%02d:%d", min,sec,mSec);
                mTv.setText(result);

            }
        };

        public void mOnclick(View v) {
            switch (v.getId()){
                case R.id.b_start:
                    mBtn_s.setEnabled(false);
                    mBtn_p.setEnabled(true);
                    mBtn_r.setEnabled(false);

                    mThread=new Thread(new Runnable(){
                        @Override
                        public void run() {
                            int i=0;
                            while (isRunning){
                                Message msg=new Message();
                                msg.arg1=i++;
                                handler.sendMessage(msg);
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                }
                            }
                        }
                    });
                    mThread.start();
                    break;

                case R.id.b_pause:
                    isRunning=false;

                    mBtn_s.setEnabled(true);
                    mBtn_p.setEnabled(false);
                    mBtn_r.setEnabled(true);
                    mThread = null;
                    break;

                case R.id.b_reset:
                    mBtn_s.setEnabled(true);
                    mBtn_p.setEnabled(false);
                    mBtn_r.setEnabled(false);

                    mTv.setText("00:00:0");
                    break;


            }
        }


        }
