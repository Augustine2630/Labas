package com.aug.labas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {

    private Button mButton;
    private Button dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notiffication);
        mButton = findViewById(R.id.notif);
        mButton.setText("Уведомление");
        mButton.setOnClickListener(v -> sendNotification());
        dialog = findViewById(R.id.button3);
        dialog.setText("Диалог");
        dialog.setOnClickListener(v -> {
            FragmentManager manager = getSupportFragmentManager();
            NewDialogFragment myDialogFragment = new NewDialogFragment();
            myDialogFragment.show(manager, "myDialog");
        });
        if (getIntent().hasExtra("fromNotification")) {
            FragmentManager manager = getSupportFragmentManager();
            NewDialogFragment myDialogFragment = new NewDialogFragment();
            myDialogFragment.show(manager, "myDialog");
        }
    }

    private int notificationId = 1;
    private String CHANNEL_ID = "my_channel_01";

    public void sendNotification() {
        createNotificationChannel();
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.putExtra("fromNotification", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.apple)
                        .setContentTitle("Крутое уведомление")
                        .setContentText("Открывает диалог")
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setContentIntent(pendingIntent)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setColor(Color.RED)
                        .setAutoCancel(true);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(notificationId, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);
            String description = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }


}