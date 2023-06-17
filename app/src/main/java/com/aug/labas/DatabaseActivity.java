package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aug.labas.database.AddingNewUser;
import com.aug.labas.database.Contract.DBContract;
import com.aug.labas.database.DatabaseHelper;
import com.aug.labas.database.model.User;

public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonDel, buttonClear, buttonShow, buttonAdd;
    EditText ET_name, ET_phone;
    TextView text;
    com.aug.labas.database.DatabaseHelper DatabaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        buttonShow = (Button) findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(this);
        buttonDel = (Button) findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(this);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);
        ET_name = (EditText) findViewById(R.id.ET_name);
        text = (TextView) findViewById(R.id.text);
        DatabaseHelper = new DatabaseHelper(this);

    }


    @Override
    public void onClick(View v) {
        String input_name = ET_name.getText().toString();
        SQLiteDatabase db = DatabaseHelper.getWritableDatabase();
        if (v.getId() == R.id.buttonShow) {
            showDB(db);
        } else if (v.getId() == R.id.buttonAdd) {
            Intent intent = new Intent(this, AddingNewUser.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            buttonShow.callOnClick();
        } else if (v.getId() == R.id.buttonDel) {
            String selection = DBContract.DBEntry.COLUMN_NAME_NAME + "=?";
            String[] selectionArgs = {input_name};
            db.delete(DBContract.DBEntry.TABLE_NAME, selection, selectionArgs);
            buttonShow.callOnClick();
        } else if (v.getId() == R.id.buttonClear) {
            db.delete(DBContract.DBEntry.TABLE_NAME, null, null);
            buttonShow.callOnClick();
        }
        DatabaseHelper.close();
    }

    private void showDB(SQLiteDatabase db) {
        text.setText("");
        String[] projection = {DBContract.DBEntry.COLUMN_NAME_ID, DBContract.DBEntry.COLUMN_NAME_NAME, DBContract.DBEntry.COLUMN_NAME_PHONE, DBContract.DBEntry.COLUMN_NAME_ADDRESS, DBContract.DBEntry.COLUMN_NAME_DATE};
        Cursor cursor = db.query(DBContract.DBEntry.TABLE_NAME, projection, null, null, null, null, null);
        int index_name = cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_NAME);
        int index_phone = cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_PHONE);
        int index_id = cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_ID);
        int index_address = cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_ADDRESS);
        int index_date = cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_DATE);

        User user = new User();
        while (cursor.moveToNext()) {
            String value_name = cursor.getString(index_name);
            String value_phone = cursor.getString(index_phone);
            Integer id = Integer.valueOf(cursor.getString(index_id));
            String value_address = cursor.getString(index_address);
            String value_date = cursor.getString(index_date);
            user.setId(id);
            user.setName(value_name);
            user.setNumber(value_phone);
            user.setAddress(value_address);
            user.setDate(value_date);
            text.append(user.toString());
        }

        cursor.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SQLiteDatabase db = DatabaseHelper.getWritableDatabase();
        showDB(db);
    }
}