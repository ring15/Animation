package com.example.animation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author ring
 * @date 2019/4/8
 */
public class ColorView extends View {

    // 设置需要用到的变量
    public static final float RADIUS = 100f;// 圆的半径 = 100
    private Paint mPaint;// 绘图画笔

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        invalidate();
    }

    public ColorView(Context context) {
        super(context);
        init();
    }

    public ColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, RADIUS, mPaint);
    }
}
