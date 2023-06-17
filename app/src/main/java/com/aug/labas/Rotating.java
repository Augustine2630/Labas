package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Rotating extends AppCompatActivity {

    ImageView myImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotating);

        myImageView = findViewById(R.id.imageView);

        ShapeDrawable d = new ShapeDrawable(new ArcShape(90, 40));
        d.setIntrinsicHeight(500);
        d.setIntrinsicWidth(500);
        d.getPaint().setColor(Color.BLUE);
        myImageView.setImageDrawable(d);
        Button buttonRotateCenter = findViewById(R.id.rotatecenter);
        Button buttonRotateCorner = findViewById(R.id.rotatecorner);

        final Animation animationRotateCenter = AnimationUtils.loadAnimation(
                this, R.anim.rotate_center);
        final Animation animationRotateCorner = AnimationUtils.loadAnimation(
                this, R.anim.rotate_corner);

        buttonRotateCenter.setOnClickListener(view -> myImageView.startAnimation(animationRotateCenter));

        buttonRotateCorner.setOnClickListener(view -> myImageView.startAnimation(animationRotateCorner));
    }
}