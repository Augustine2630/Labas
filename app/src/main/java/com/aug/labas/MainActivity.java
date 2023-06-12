package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.button);
        mButton.setText("Lab 1");
        mButton.setOnClickListener(v -> openNewActivity());
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, TextFormatter.class);
        startActivity(intent);
    }



}