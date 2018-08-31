package com.morse.mlibrary.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.morse.mlibrary.R;

/**
 * 自定义柱状图
 */
public class BarChat extends View {

    private Paint mPaint;
    private Paint textPaint;
    private int mCount;
    private int mWidth;
    private int mRectHeight;
    private int mRectWidth;
    private LinearGradient mLinearGradient;
    private double mRandom;
    private float mCurrentHeight;
    private Paint xPaint;
    private Rect mBound;

    public static int OFFSET = 5;

    public BarChat(Context context) {
        this(context, null);
    }

    public BarChat(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarChat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        mBound = new Rect();

        xPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        xPaint.setColor(Color.RED);
        xPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        xPaint.setStrokeWidth(5);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BarChat);
        if (null != ta) {
            mCount = ta.getInt(R.styleable.BarChat_count, 6);
            ta.recycle();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getMeasuredWidth();
        mRectHeight = (int) (getMeasuredHeight() * 0.9);
        mRectWidth = (int) (mWidth * 0.8 / mCount);
        OFFSET = (int) (mWidth * 0.2 / (mCount + 2));
        mLinearGradient = new LinearGradient(0, 0, mRectWidth, mRectHeight, Color.GREEN, Color.YELLOW, Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(OFFSET, mRectHeight, mWidth, mRectHeight, xPaint);//绘制X轴
        canvas.drawLine(OFFSET, 0, OFFSET, mRectHeight, xPaint);//绘制Y轴
        for (int i = 0; i < mCount; i++) {
            mRandom = Math.random();
            mCurrentHeight = (float) (mRectHeight * mRandom);
//            float width = (float) (mWidth * 0.4 / 2 + OFFSET);
            //绘制柱状图
            canvas.drawRect(mRectWidth * i + OFFSET * (i + 2), mCurrentHeight, (i + 1) * (mRectWidth + OFFSET) + OFFSET, mRectHeight, mPaint);
            String text = (i + 1) + "";
            textPaint.getTextBounds(text, 0, text.length(), mBound);
            //绘制X文本
            canvas.drawText(text, OFFSET * (i + 2) + mRectWidth * i + (mRectWidth - mBound.width()) / 2, mRectHeight + mBound.height() * 2, textPaint);
            String height = (mRectHeight - mCurrentHeight) + "";
            textPaint.getTextBounds(height, 0, height.length(), mBound);
            //绘制柱状图值
            canvas.drawText(height, OFFSET * (i + 2) + mRectWidth * i + (mRectWidth - mBound.width()) / 2, mCurrentHeight - mBound.height() / 2, textPaint);
        }
    }
}
