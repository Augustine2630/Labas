package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    private Button lab2;
    private Button buttonNotif;

    private Button button4;

    private Button lab5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        lab5 = findViewById(R.id.lab5);
        buttonNotif = findViewById(R.id.button4);
        mButton.setText("Lab 1");
        mButton.setOnClickListener(v -> openNewActivity());
        lab2 = findViewById(R.id.button2);
        lab2.setOnClickListener(v -> openNewActivityLab2());
        buttonNotif.setOnClickListener(v -> openNewActivityLab3());
        buttonNotif.setText("LAB 3");
        button4 = findViewById(R.id.button5);
        button4.setText("LAB 4");
        button4.setOnClickListener(v -> openNewActivityLab4());
        lab5.setText("LAB 5");
        lab5.setOnClickListener(v -> openNewActivityLab5());
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, TextFormatter.class);
        startActivity(intent);
    }

    public void openNewActivityLab2() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void openNewActivityLab3() {
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }
    public void openNewActivityLab4() {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void openNewActivityLab5() {
        Intent intent = new Intent(this, SingleTouchActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //notification callbacks here in activity
        //Call method here from non activity class.

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}