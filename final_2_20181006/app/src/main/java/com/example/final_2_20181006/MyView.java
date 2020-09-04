package com.example.final_2_20181006;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MyView extends View {

    private Point mPoint=new Point();
    private Rect mRect;
    int i=3;
    int score = 0;
    Thread mThread;
    Handler mHandler=new Handler();
    public MyView(Context context) {
        super(context);

        mThread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (Thread.currentThread()==mThread){


                    mHandler.post( new Runnable() {
                        Random r1=new Random();
                        Random r2=new Random();

                        int l=r1.nextInt(400);
                        int t=r2.nextInt(500)+100;
                        @Override
                        public void run() {
                            mRect = new Rect(l,t,l+50, t+50);

                            invalidate();

                        }
                    });


                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                    }
                }
            }
        });
        mThread.start();



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p =new Paint();
        p.setTextSize(30);

        p.setColor(Color.BLUE);

        canvas.drawText("기회 : "+ i , 0,30,p);
        canvas.drawText("점수 : "+ score , 0,70,p);

        p.setColor(Color.RED);

        canvas.drawRect(mRect, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x=(int)event.getX();
        int y=(int)event.getY();

        mPoint.set(x,y);

        if(event.getAction()==MotionEvent.ACTION_DOWN){
            if(mRect.contains(x, y))
                score=score+1;
            else
                i=i-1;
        }

        if(i==0){
            invalidate();
            mThread=null;
        }

        return true;
    }
}
