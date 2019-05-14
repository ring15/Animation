package com.example.animation.evaluator;

import android.animation.TypeEvaluator;

import com.example.animation.Point;

/**
 * @author ring
 * @date 2019/4/8
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float a = 9.8f;
        float x = startPoint.getX();
        float y = startPoint.getY() + a * fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }
}
