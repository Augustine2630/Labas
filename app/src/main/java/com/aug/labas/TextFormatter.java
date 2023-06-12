package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TextFormatter extends AppCompatActivity {

    private EditText editText;

    private Button bButton;
    private Button iButton;
    private Button plusButton;
    private Button minusButton;
    private Button redButton;
    private Button yellowButton;
    private Button greenButton;
    private Button blackButton;
    private Button blueButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_formatter);
        textView = findViewById(R.id.textSize);
        initButtons();
        editText = findViewById(R.id.formattedText);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP,32);
        editText.setText("Введите текст");
        textView.setText("Text size: " + Math.round(editText.getTextSize()));
        editText.setOnClickListener(view -> editText.getText().clear());
        RadioButton serif = findViewById(R.id.radio_serif);
        RadioButton sansSerif = findViewById(R.id.radio_sans_serif);
        RadioButton mono = findViewById(R.id.radio_mono);
        serif.setText("Serif");
        sansSerif.setText("SansSerif");
        mono.setText("Monospace");
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        bButton.setOnClickListener(v -> {
            if (!editText.getTypeface().isBold()){
                editText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            } else {
                editText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        });
        iButton.setOnClickListener(v -> {
            if (!editText.getTypeface().isItalic()){
                editText.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            } else {
                editText.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }

        });

        plusButton.setOnClickListener(v -> {
            editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) ((editText.getTextSize() + 1)/3.5));
            textView.setText("Text size: " + Math.round(editText.getTextSize()));
        });
        minusButton.setOnClickListener(v -> {
            editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, (float) ((editText.getTextSize() - 1)/3.5));
            textView.setText("Text size: " + Math.round(editText.getTextSize()));
        });

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radio_serif){
                editText.setTypeface(Typeface.SERIF);
            } else if (checkedId == R.id.radio_sans_serif) {
                editText.setTypeface(Typeface.SANS_SERIF);
            } else if (checkedId == R.id.radio_mono){
                editText.setTypeface(Typeface.MONOSPACE);
            } else {
                System.out.println("aboba");
            }
        });
        redButton.setOnClickListener(v -> editText.setTextColor(Color.RED));
        yellowButton.setOnClickListener(v -> editText.setTextColor(Color.YELLOW));
        greenButton.setOnClickListener(v -> editText.setTextColor(Color.GREEN));
        blackButton.setOnClickListener(v -> editText.setTextColor(Color.BLACK));
        blueButton.setOnClickListener(v -> editText.setTextColor(Color.BLUE));
    }

    private void initButtons(){
        bButton = findViewById(R.id.B);
        iButton = findViewById(R.id.I);
        plusButton = findViewById(R.id.plus);
        minusButton = findViewById(R.id.minus);
        redButton = findViewById(R.id.red);
        yellowButton = findViewById(R.id.yellow);
        greenButton = findViewById(R.id.green);
        blackButton = findViewById(R.id.black);
        blueButton = findViewById(R.id.blue);


        redButton.setBackgroundColor(Color.RED);
        yellowButton.setBackgroundColor(Color.YELLOW);
        greenButton.setBackgroundColor(Color.GREEN);
        blackButton.setBackgroundColor(Color.BLACK);
        blueButton.setBackgroundColor(Color.BLUE);
    }




}