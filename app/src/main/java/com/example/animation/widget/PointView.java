package com.example.animation.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.example.animation.Point;

/**
 * @author ring
 * @date 2019/4/8
 */
public class PointView extends View {

    private Paint mPaint;
    private Point currentPoint;
    public static final float RADIUS = 70f;// 圆的半径 = 70

    public PointView(Context context) {
        super(context);
        init();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint == null) {
            currentPoint = new Point(RADIUS, RADIUS);
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
            Point startPoint = new Point(RADIUS, RADIUS);
            Point endPoint = new Point(RADIUS, 700);
//            ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, getHeight() - 70);
            valueAnimator.setDuration(1000);
            valueAnimator.setInterpolator(new AccelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
//                    currentPoint = (Point) animation.getAnimatedValue();
                    float y = (Float) animation.getAnimatedValue();
                    Point point = new Point(RADIUS, y);
                    currentPoint = point;
                    invalidate();
                }
            });
            valueAnimator.start();
        } else {
            float x = currentPoint.getX();
            float y = currentPoint.getY();
            canvas.drawCircle(x, y, RADIUS, mPaint);
        }
    }
}
