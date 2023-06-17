package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private Button toFirst;
    private EditText editText;

    private Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        toFirst = findViewById(R.id.toFirst);
        editText = findViewById(R.id.value);
        callButton = findViewById(R.id.callButton);
        callButton.setOnClickListener(v -> callNumber());
        toFirst.setOnClickListener(v -> openSecondActivity());
        editText.setOnClickListener(v -> editText.getText().clear());
    }


    public void openSecondActivity() {
        Intent openMainActivity = new Intent(this, FirstActivity.class);
        openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        setCurrentDefaultHomeApp(String.valueOf(editText.getText()));
        startActivityIfNeeded(openMainActivity, 0);
    }

    private void callNumber(){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+ editText.getText())); //change the number
        startActivity(callIntent);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setCurrentDefaultHomeApp(String value){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        editor.putString("Key", value);
        editor.apply();
    }
}