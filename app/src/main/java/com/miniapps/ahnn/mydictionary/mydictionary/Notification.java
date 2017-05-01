package com.miniapps.ahnn.mydictionary.mydictionary;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.miniapps.ahnn.mydictionary.mydictionary.DataBase.DataOperation;
import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by AhmedKhaled on 4/29/2017.
 */

public class Notification extends BroadcastReceiver {

    private int number = 1, notificaion_id;
    private Random rand = new Random();
    private Word word;
    private NotificationCompat.Builder builder;
    private NotificationManager manager;
    private RemoteViews remoteViews;


    @Override
    public void onReceive(Context context, Intent intent) {
        DataOperation operation = new DataOperation(context);
        number = rand.nextInt(operation.getCount()) + 0;
        if (number < operation.getCount()) {
            number = 1;
        } else {
            number++;
        }
        word = operation.getnotification(number);
        number++;
        CreateNotification(context, word);
    }

    private void CreateNotification(Context context, Word word) {
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification);
        remoteViews.setTextViewText(R.id.notic_word_title, word.getWord());
        remoteViews.setTextViewText(R.id.notic_word_mean, word.getMeaning());
        remoteViews.setTextViewText(R.id.notifcation_time, GetTime());
        notificaion_id = (int) System.currentTimeMillis();
        PendingIntent notificIntent = PendingIntent.getActivity(context, 0,
                new Intent(), 0);
        builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setCustomBigContentView(remoteViews)
                .setContentIntent(notificIntent);
        manager.notify(notificaion_id, builder.build());

    }

    private String GetTime() {
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk:mm a");
        String time = simpleDateFormat.format(calender.getTime());
        return time;
    }
}
