package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    private Button lab2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setText("Lab 1");
        mButton.setOnClickListener(v -> openNewActivity());
        lab2 = findViewById(R.id.button2);
        lab2.setOnClickListener(v -> openNewActivityLab2());
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, TextFormatter.class);
        startActivity(intent);
    }

    public void openNewActivityLab2(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }


}