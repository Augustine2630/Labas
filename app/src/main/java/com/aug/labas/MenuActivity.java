package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final TextView my_text = (TextView) findViewById(R.id.my_text);
        my_text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PenguinAttackCyrillic.otf"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout mylayout = (LinearLayout) findViewById(R.id.root);
        if (item.getItemId() == R.id.red){
            mylayout.setBackgroundColor(getResources().getColor(R.color.purple_200));
            return true;
        } else if (item.getItemId() == R.id.green) {
            mylayout.setBackgroundColor(getResources().getColor(R.color.purple_500));
            return true;
        } else if (item.getItemId() == R.id.blue) {
            mylayout.setBackgroundColor(getResources().getColor(R.color.purple_700));
            return true;
        } else if (item.getItemId() == R.id.exit) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}