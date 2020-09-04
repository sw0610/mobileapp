package com.example.hw8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class hw8 extends View {

    private ArrayList<Vertex> mVList;
    private Point mPoint = null;
    private Bitmap m_icon = BitmapFactory.decodeResource(getResources(),R.drawable.android_s);
    int width=m_icon.getWidth();
    int height=m_icon.getHeight();
    int cx;
    int cy;
    int dx;
    int dy;


    public hw8(Context context) {
        super(context);
        mVList = new ArrayList<Vertex>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mVList.size(); i++) {

            if (mVList.get(i).isDraw) {

                canvas.drawBitmap(m_icon, mVList.get(i).x - width / 2, mVList.get(i).y - height / 2, null);
            } else {
                canvas.drawBitmap(m_icon, cx - width / 2, cy - height / 2, null);

            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        cx = (int)event.getX();
        cy = (int)event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                mVList.add(new Vertex(cx, cy, false));

                for (int i = 0; i < mVList.size(); i++) {
                    if (mVList.get(i).x - width / 2 < cx && cx < mVList.get(i).x + width / 2
                            && mVList.get(i).y - height / 2 < cy && cy < mVList.get(i).y + height / 2) {
                        mPoint = new Point(cx, cy);

                    }
                    else{
                        mVList.add(new Vertex(cx, cy, true));

                        invalidate();
                }
            }

                return true;

            case MotionEvent.ACTION_MOVE:

                if (mPoint != null) {
                    dx = cx - mPoint.x;
                    dy = cy - mPoint.y;
                    mPoint.set(dx, dy);
                    invalidate();
                        }
                 break;

        }
        return false;

    }

}
class Vertex {
    float x, y;
    boolean isDraw;

    public Vertex(float x, float y, boolean isDraw) {
        this.x = x;
        this.y = y;
        this.isDraw = isDraw;
    }

}

