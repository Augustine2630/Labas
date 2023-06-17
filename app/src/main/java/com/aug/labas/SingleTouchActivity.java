package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

public class SingleTouchActivity extends AppCompatActivity {

    TextView downX;
    TextView downY;
    TextView upX;
    TextView upY;
    TextView moveX;
    TextView moveY;

    private int mActivePointerId;

    private Button gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        downX = findViewById(R.id.down_x);
        downY = findViewById(R.id.down_y);
        upX = findViewById(R.id.up_x);
        upY = findViewById(R.id.up_y);
        moveX = findViewById(R.id.move_x);
        moveY = findViewById(R.id.move_y);
        gesture = findViewById(R.id.gesture);
        gesture.setOnClickListener(v -> gestureActivity());
    }

    private void gestureActivity() {
        Intent intent = new Intent(this, MultiTouchActivity.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String x;
        String y;
        int action = event.getAction();
        x = Integer.toString((int) event.getX());
        y = Integer.toString((int) event.getY());
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                downX.setText("downX: " + x);
                downY.setText("downY: " + y);
                return true;
            case (MotionEvent.ACTION_MOVE):
                moveX.setText("moveX: " + x);
                moveY.setText("moveY: " + y);
                upX.setText("");
                upY.setText("");
                return true;
            case (MotionEvent.ACTION_UP):
                upX.setText("upX: " + x);
                upY.setText("upY: " + y);
                moveX.setText("");
                moveY.setText("");
                return true;
            default:
                return super.onTouchEvent(event);
        }

    }
}