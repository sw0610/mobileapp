package com.example.customviewex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    private String mColor = "FF0000FF";//프로그램적으로 기술시 #없이 투명도까지

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.YELLOW); //onDraw 호출시 흰색으로->의미 없음

        for (int i = 0; i < attrs.getAttributeCount();i++){
            if(attrs.getAttributeName(i).equals("color")){
                String c = attrs.getAttributeValue(i);

                if(c != null)//가져온 내용이 있으면
                    mColor = c.replace("#","FF");
                //xml에서 기술된 것을 프로그램적으로 사용위해
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //height 진짜 크기 구하기
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = 0;
        switch(heightMode){
            case MeasureSpec.UNSPECIFIED: //mode가 셋팅되지 않은 크기가 넘어올 떄
                heightSize = heightMeasureSpec;
                break;
            case MeasureSpec.AT_MOST: //warp_content(뷰 크기에 따라 달라짐)
                heightSize = 200;
                break;
            case MeasureSpec.EXACTLY: //fill_parent, match_parent(외부에서 이미 크기 지정됨)
                heightSize = MeasureSpec.getSize(heightMeasureSpec);
                break;
        }

        //width 진짜 크기 구하기
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = 0;
        switch(widthMode){
            case MeasureSpec.UNSPECIFIED: //mode가 셋팅되지 않은 크기가 넘어올 떄
                widthSize = widthMeasureSpec;
                break;
            case MeasureSpec.AT_MOST: //warp_content(뷰 크기에 따라 달라짐)
                widthSize = 320;
                break;
            case MeasureSpec.EXACTLY: //fill_parent, match_parent(외부에서 이미 크기 지정됨)
                widthSize = MeasureSpec.getSize(widthMeasureSpec);
                break;
        }

        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint pnt = new Paint();
        //pnt.setColor(Color.BLUE);
        pnt.setColor((int)Long.parseLong(mColor, 16));//16진수로

        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(100,100,80,pnt);
    }
}
