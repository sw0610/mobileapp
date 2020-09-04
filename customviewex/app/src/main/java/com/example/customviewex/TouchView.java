package com.example.customviewex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class TouchView extends View {

    private Point mPoint = new Point();
    private String mStrAction = "NONE";

    public TouchView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setTextSize(20);//픽셀
        p.setColor(Color.BLUE);

        //이벤트 발생 시 좌표값 저장 후 onDraw에서 출력
        canvas.drawText("Event POS. X : "+mPoint.x+", Y : "+mPoint.y,0,20,p);
        canvas.drawText("Event Action : "+mStrAction,0,50,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();//원래는 float로 반환->int타입으로
        int y = (int)event.getY();
        mPoint.set(x,y);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: //터치를 하고있는지
                mStrAction = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE://터치된 상태에서 움직임이 발생했는지
                mStrAction = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP: //터치가 해제 되었는지
                mStrAction = "ACTION_UP";
                break;
        }

        //화면을 다시 그려야 할 시점에
        invalidate();//강제적으로 onDraw()호출하는 효과
        //onDraw()는 canvas객체 호출 해야 하기 때문에 x

        return true;
       // return super.onTouchEvent(event);
    }
}
