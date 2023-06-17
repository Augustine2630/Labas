package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FirstActivity extends AppCompatActivity {


    private Button toSecond;
    public TextView textView;

    private List<String> logs = new ArrayList<>();

    private Button contacts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        toSecond = findViewById(R.id.toSecond);
        toSecond.setOnClickListener(v -> openSecondActivity());
        textView = findViewById(R.id.textView);
        contacts = findViewById(R.id.button6);
        contacts.setOnClickListener(v -> openContacts());
    }


    public void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void openContacts() {
        Intent intent = new Intent(this, ContactsList.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }


    public List<String> getLogs() {
        return logs;
    }

    public void setLogs(List<String> logs) {
        this.logs = logs;
    }

    public void addToLogs(String text){
        logs.add(text);
    }

    @Override
    protected void onResume() {
        super.onResume();

        addToLogs("first activity");
        if (!getCurrentDefaultHomeApp().equals("Введите номер")){
            addToLogs(getCurrentDefaultHomeApp());
        } else {
            addToLogs("Empty");
        }
        StringBuilder stringBuilder = new StringBuilder();
        logs.forEach(t -> stringBuilder.append(t).append("\n"));
        textView.setText(stringBuilder);
    }

    private String getCurrentDefaultHomeApp(){
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Key", "DefaultValue");
    }
}