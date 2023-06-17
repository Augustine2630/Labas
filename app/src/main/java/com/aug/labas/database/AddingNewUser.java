package com.aug.labas.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.aug.labas.R;
import com.aug.labas.database.Contract.DBContract;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicReference;

public class AddingNewUser extends AppCompatActivity {

    EditText ET_name, ET_phone, ET_address;

    com.aug.labas.database.DatabaseHelper DatabaseHelper;

    private DatePicker mDatePicker;

    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_new_user);
        ET_name = (EditText) findViewById(R.id.ET_name);
        ET_name.setText("Имя");
        ET_phone = (EditText) findViewById(R.id.ET_phone);
        ET_phone.setText("Номер");
        ET_address = (EditText) findViewById(R.id.ET_address);
        ET_address.setText("Адрес");
        ET_address.setOnClickListener(v -> ET_address.getText().clear());
        ET_name.setOnClickListener(v -> ET_name.getText().clear());
        ET_phone.setOnClickListener(v -> ET_phone.getText().clear());
        DatabaseHelper = new DatabaseHelper(this);
        mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        addBtn = findViewById(R.id.addButton);
        Calendar today = Calendar.getInstance();
        mDatePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                        Toast.makeText(getApplicationContext(),
                                "Дата выбрана", Toast.LENGTH_SHORT).show();
                    }
                });
        AtomicReference<String> date = new AtomicReference<>("");
        mDatePicker.setOnClickListener(v -> date.set(String.valueOf(new StringBuilder()
                .append(mDatePicker.getDayOfMonth()).append(".")
                .append(mDatePicker.getMonth() + 1).append(".")
                .append(mDatePicker.getYear()))));
        addBtn.setOnClickListener(v -> addNewUser(date.get()));
    }



    public void addNewUser(String date){
        if (date.equals("")){
            date = "01-01-1990";
        }
        SQLiteDatabase db = DatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String input_name = ET_name.getText().toString();
        String input_phone = ET_phone.getText().toString();
        String input_address = ET_address.getText().toString();
        values.put(DBContract.DBEntry.COLUMN_NAME_NAME, input_name);
        values.put(DBContract.DBEntry.COLUMN_NAME_PHONE, input_phone);
        values.put(DBContract.DBEntry.COLUMN_NAME_ADDRESS, input_address);
        values.put(DBContract.DBEntry.COLUMN_NAME_DATE, date);
        db.insert(DBContract.DBEntry.TABLE_NAME, null, values);
        finish();
    }


}