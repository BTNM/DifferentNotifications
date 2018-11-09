package com.example.btnm.differentnotifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.app.Notification.EXTRA_NOTIFICATION_ID;

public class MainActivity extends AppCompatActivity {

//    String notificationTitle = "Drink Water Test";
//    String notificationText = "Drink Check, time to drink water, at least 150 ml (0,15 liter) water";

//    private int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testButton = (Button) findViewById(R.id.testBtn);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testCall();
            }
        });

    }

    public void testCall() {
        String notificationTitle = "Drink Water Test";
        String notificationText = "Drink Check, time to drink water, at least 150 ml (0,15 liter) water";
//
//        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this, "channel_id" )
//                .setDefaults(NotificationCompat.DEFAULT_ALL)
//                .setSmallIcon(R.drawable.ic_stat_notification)
////                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cartoon_water_drops) )
//                .setContentTitle(notificationTitle)
////                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setContentText(notificationText);
//
//
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(1, mBuilder.build() );

        String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_HIGH);

            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder
                .setAutoCancel(true)
//                .setDefaults(Notification.DEFAULT_ALL)
//                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.water_droplet2)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.water_drop_icon) )
//                .setTicker("Hearty365")
//                .setPriority(Notification.PRIORITY_MAX)
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setContentInfo("Info Water");

        notificationManager.notify(/*notification id*/1, notificationBuilder.build());


    }

//    public void sendNotification (View view) {
//        Intent waitIntent = new Intent();
//        waitIntent.setAction(ACTION_SNOOZE);
//        waitIntent.putExtra(EXTRA_NOTIFICATION_ID, 0):
//        PendingIntent waitPendingIntent = PendingIntent.getBroadcast(this, 0, waitIntent,0);
//
//
//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.drawable.ic_stat_notification)
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cartoon_water_drops) )
//                .setContentTitle(notificationTitle)
//                .setContentText(notificationText)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                .setContentIntent(pendingIntent)
//                .addAction(R.drawable.cartoon_water_drops, getString(R.string.snooze), waitPendingIntent);
//
//
//    }
//
//    private void createNotificationChannel () {
//        CharSequence name = getString(R.string.channel_name);
//    }





}
