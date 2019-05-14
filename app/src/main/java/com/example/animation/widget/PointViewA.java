package com.example.animation.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.animation.Point;
import com.example.animation.evaluator.PointEvaluator;

/**
 * @author ring
 * @date 2019/4/8
 */
public class PointViewA extends View {

    // 设置需要用到的变量
    public static final float RADIUS = 70;// 圆的半径 = 70
    private Paint mPaint;// 绘图画笔
    private Point currentPoint;

    private float yPosition;

    public float getYPosition() {
        return yPosition;
    }

    public void setYPosition(float yPosition) {
        this.yPosition = yPosition;
        Point point = new Point(RADIUS, yPosition);
        currentPoint = point;
        invalidate();
    }

    public PointViewA(Context context) {
        super(context);
        init();
    }

    public PointViewA(Context context, @Nullable AttributeSet attrs) {
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
        if (currentPoint == null) {
            currentPoint = new Point(RADIUS, RADIUS);
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
        } else {
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }
    }
}
