package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MultiTouchActivity extends AppCompatActivity {

    private GestureDetector mDetector;

    private TextView singleTap;
    private TextView longPress;
    private TextView doubleTap;
    private TextView scroll;
    private TextView flip;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_touch);
        View myView = findViewById(R.id.view);
        mDetector = new GestureDetector(this, new MyGestureListener());
        myView.setOnTouchListener(touchListener);

        singleTap = findViewById(R.id.singleTap);
        longPress = findViewById(R.id.longPress);
        doubleTap = findViewById(R.id.doubleTap);
        scroll = findViewById(R.id.scroll);
        flip = findViewById(R.id.flip);
        singleTap.setText("singleTap");
        longPress.setText("longPress");
        doubleTap.setText("doubleTap");
        scroll.setText("scroll");
        flip.setText("flip");
    }


    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return mDetector.onTouchEvent(event);
        }
    };

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d("TAG","onDown: ");
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.i("TAG", "onSingleTapConfirmed: ");
            Toast.makeText(getApplicationContext(),
                    "SINGLE TAP", Toast.LENGTH_LONG).show();
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.i("TAG", "onLongPress: ");
            Toast.makeText(getApplicationContext(),
                    "LONG PRESS", Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.i("TAG", "onDoubleTap: ");
            Toast.makeText(getApplicationContext(),
                    "DOUBLE TAP", Toast.LENGTH_LONG).show();
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            Log.i("TAG", "onScroll: ");
            Toast.makeText(getApplicationContext(),
                    "SCROLL", Toast.LENGTH_LONG).show();
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d("TAG", "onFling: ");
            Toast.makeText(getApplicationContext(),
                    "FLING", Toast.LENGTH_LONG).show();
            return true;
        }
    }
}