package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Shape2D extends AppCompatActivity {

    ImageView imageView;

    private Button rotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_2d);
        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundColor(Color.TRANSPARENT);
        ShapeDrawable d = new ShapeDrawable(new RectShape());
        d.setIntrinsicHeight(500);
        d.setIntrinsicWidth(1000);
        d.getPaint().setColor(Color.RED);
        imageView.setImageDrawable(d);

        rotate = findViewById(R.id.rotate);
        rotate.setOnClickListener(v -> openNewActivity());
    }




    public void openNewActivity() {
        Intent intent = new Intent(this, Rotating.class);
        startActivity(intent);
    }
}