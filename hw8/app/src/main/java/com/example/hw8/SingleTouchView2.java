package com.example.hw8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchView2 extends View {

    private Point mPoint = null;
    private Rect mRect;

    public SingleTouchView2(Context context) {
        super(context);

        mRect = new Rect(0,0,100,100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p= new Paint();
        p.setColor(Color.RED);

        canvas.drawRect(mRect, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        super.onTouchEvent(event);

        int cx = (int)event.getX();
        int cy = (int)event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(mRect.contains(cx,cy)) //사각형 안에 포함되어 있는지 확인
                    mPoint = new Point(cx, cy); //클릭지점 mPoint에 저장
                else{
                    mRect.set(cx-50, cy-50,cx+50,cy+50);//없으면 사각영역 값 클릭 지점으로 재설정
                    invalidate();
                }

                return true;

            case MotionEvent.ACTION_MOVE:
                if(mPoint != null){ //클릭 지점을 기준으로 잡고 움직임
                    int dx = cx-mPoint.x;
                    int dy = cy-mPoint.y;
                    mRect.offset(dx,dy);
                    invalidate();
                    mPoint.set(cx,cy);
                }
                return true;

            case MotionEvent.ACTION_UP:
                mPoint = null;
        }
        return false;

    }
}
