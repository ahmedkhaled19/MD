package com.miniapps.ahnn.mydictionary.mydictionary.HomeActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.miniapps.ahnn.mydictionary.mydictionary.Notification;
import com.miniapps.ahnn.mydictionary.mydictionary.SharedPreference;
import com.miniapps.ahnn.mydictionary.mydictionary.Word;

import java.util.GregorianCalendar;

/**
 * Created by NaderNabil on 4/24/2017.
 */

public class HomePresenter {

    private HomeView view;
    private HomeModel model;
    private Context context;

    public HomePresenter(Context context, HomeView view, HomeModel model) {
        this.context = context;
        this.view = view;
        this.model = model;
        GetData();
        if (SharedPreference.getInstance().IsNotifc()) {
            BulidNotification();
        }
    }

    private void BulidNotification() {
        if (SharedPreference.getInstance().TimeChange()) {
            Intent alertIntent = new Intent(context, Notification.class);
            AlarmManager alarmManager = (AlarmManager)
                    context.getSystemService(Context.ALARM_SERVICE);
            if (SharedPreference.getInstance().Time() == 5) {
                Long alerttime = new GregorianCalendar().getTimeInMillis() + 5 * 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerttime,
                        PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        alerttime,
                        5 * 1000, PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
            }
            if (SharedPreference.getInstance().Time() == 10) {
                Long alerttime = new GregorianCalendar().getTimeInMillis() + 10 * 60 * 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerttime,
                        PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        alerttime,
                        10 * 60 * 1000, PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
            }
            if (SharedPreference.getInstance().Time() == 30) {
                Long alerttime = new GregorianCalendar().getTimeInMillis() + 30 * 60 * 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerttime,
                        PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        alerttime,
                        30 * 60 * 1000, PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));

            }
            if (SharedPreference.getInstance().Time() == 60) {
                Long alerttime = new GregorianCalendar().getTimeInMillis() + 60 * 60 * 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerttime,
                        PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        alerttime,
                        60 * 60 * 1000, PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));

            }
            if (SharedPreference.getInstance().Time() == 360) {
                Long alerttime = new GregorianCalendar().getTimeInMillis() + 360 * 60 * 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerttime,
                        PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        alerttime,
                        360 * 60 * 1000, PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));

            }
            if (SharedPreference.getInstance().Time() == 720) {
                Long alerttime = new GregorianCalendar().getTimeInMillis() + 720 * 60 * 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerttime,
                        PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        alerttime,
                        720 * 60 * 1000, PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));

            }
            if (SharedPreference.getInstance().Time() == 1440) {
                Long alerttime = new GregorianCalendar().getTimeInMillis() + 1440 * 60 * 1000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, alerttime,
                        PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                        alerttime,
                        1440 * 60 * 1000, PendingIntent.getBroadcast(context, 1, alertIntent,
                                PendingIntent.FLAG_UPDATE_CURRENT));

            } else {
                alarmManager.cancel(PendingIntent.getBroadcast(context, 1, alertIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT));
            }
        }
    }

    private void GetData() {
        view.SetData(model.GetDATA(context));
    }

    public void DeleteWord(Word word) {
        Log.d("Ahmeddd","in delete");
        //model.Delete(context, word);
    }

    public void UpdateWord(Word word) {
        model.Update(context, word);
    }

    protected void speakWords(String speech) {
        view.SpeakWord(speech);
    }



}
