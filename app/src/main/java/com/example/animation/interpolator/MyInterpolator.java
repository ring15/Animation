package com.example.animation.interpolator;

import android.animation.TimeInterpolator;

/**
 * @author ring
 * @date 2019/4/8
 */
public class MyInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 9.8f;
    }
}
