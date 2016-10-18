package com.itheima.leon.drawtextdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * 创建者:   Leon
 * 创建时间:  2016/10/18 22:08
 * 描述：    TODO
 */
public class MyTextView extends View {

    private Paint mPaint;

    public MyTextView(Context context) {
        this(context, null);
    }

//    private float x = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
//    private float y = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 18, getResources().getDisplayMetrics()));
        //If we use Align.Center, we can set x = getWith()/2; in onDraw method
//        mPaint.setTextAlign(Paint.Align.CENTER);

    }

    /**
     * Draw a text in view center
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        String test = "Hello Son";
        float textWidth = mPaint.measureText(test);
        float x = getWidth() / 2 - textWidth / 2;

        Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
        float textHeight = fontMetrics.descent - fontMetrics.ascent;
        float y =  getHeight()/2 + textHeight/2  - fontMetrics.descent;//baseline position
        canvas.drawText("Hello Son", x , y, mPaint);
    }
}
