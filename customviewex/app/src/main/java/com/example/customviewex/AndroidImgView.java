package com.example.customviewex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class AndroidImgView extends View {

    Bitmap mBmp;

    public AndroidImgView(Context context) {
        super(context);

        mBmp= BitmapFactory.decodeResource(getResources(),R.drawable.android);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBmp,0,0,null);
    }
}
