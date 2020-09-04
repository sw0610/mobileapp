package com.example.hw8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchView1 extends View {

    private Point mPoint = new Point(0,150);
    private String mStrAction = "NONE";
    private Bitmap m_icon = BitmapFactory.decodeResource(getResources(),R.drawable.android_s);

    public SingleTouchView1(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setTextSize(20);
        p.setColor(Color.BLUE);

        canvas.drawText("Event POS. X : "+mPoint.x+", Y : "+mPoint.y,0,20,p);
        canvas.drawText("Event Action : "+mStrAction,0,50,p);
        canvas.drawBitmap(m_icon,mPoint.x,mPoint.y,null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        mPoint.set(x,y);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mStrAction = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                mStrAction = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                mStrAction = "ACTION_UP";
                break;
        }

        invalidate();

        return true;
    }
}
