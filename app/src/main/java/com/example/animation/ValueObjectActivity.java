package com.example.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;

import com.example.animation.evaluator.ColorEvaluator;
import com.example.animation.evaluator.PointEvaluator;
import com.example.animation.interpolator.MyInterpolator;
import com.example.animation.widget.ColorView;
import com.example.animation.widget.PointViewA;

public class ValueObjectActivity extends AppCompatActivity {

    private Button mObjectAnimator;
    private ColorView mColorView;
    private PointViewA mPointViewA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_object);
        mObjectAnimator = findViewById(R.id.btn_object_animator);
        mColorView = findViewById(R.id.view_color);
        mPointViewA = findViewById(R.id.point_a);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mObjectAnimator, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofObject(mColorView, "color",new ColorEvaluator(),"#ff0000","#ffffff");
        objectAnimator1.setDuration(5000);
        objectAnimator1.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator1.start();
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mPointViewA,"yPosition",70,1800);
        objectAnimator2.setDuration(3000);
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(0.098f);
        objectAnimator2.setInterpolator(new MyInterpolator());
        objectAnimator2.start();

    }
}
