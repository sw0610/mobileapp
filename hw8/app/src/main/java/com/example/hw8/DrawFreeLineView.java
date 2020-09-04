package com.example.hw8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawFreeLineView extends View {

    private ArrayList<Vertex2> mVList;
    private Paint mPaint;

    public DrawFreeLineView(Context context) {
            super(context);

            mPaint = new Paint();
            mPaint.setColor(Color.BLACK);
            mPaint.setStrokeWidth(3);
            mPaint.setAntiAlias(true);

            mVList = new ArrayList<Vertex2>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        //정점을 순회하면서 선분으로 잇는다
        for(int i=0; i<mVList.size();i++){
            if(mVList.get(i).isDraw){//isDraw가 참인 경우에만 이어그림
                canvas.drawLine(mVList.get(i-1).x,mVList.get(i-1).y,
                        mVList.get(i).x,mVList.get(i).y,mPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mVList.add(new Vertex2(event.getX(),event.getY(),false));
                return true;

            case MotionEvent.ACTION_MOVE:
                mVList.add(new Vertex2(event.getX(),event.getY(),true));
                invalidate();
                return true;
        }
        return false;
    }
}
class Vertex2{
    float x,y;
    boolean isDraw;

    public Vertex2(float x, float y, boolean isDraw){
        this.x=x;
        this.y=y;
        this.isDraw=isDraw; //이전 지점과 연결 할 것인지
    }
}