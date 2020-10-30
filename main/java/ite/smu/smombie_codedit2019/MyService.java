package ite.smu.smombie_codedit2019;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static android.content.Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT;

public class MyService extends Service {
    private  boolean isStop;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startForegroundService();
        //Toast.makeText(getApplicationContext(), "onCreate 실행.", Toast.LENGTH_SHORT).show();
    }

//    private class Counter implements Runnable{
//        private int count;
//        private Handler handler = new Handler();
//
//        @Override
//        public void run() {
//            for (count = 0; count < 50; count++) {
//                if (isStop)
//                    break;
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        //Toast.makeText(getApplicationContext(), count + "", Toast.LENGTH_SHORT).show();
//                        Log.d("COUNT", count + "");
//                    }
//                });
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(getApplicationContext(), "서비스가 종료되었습니다.", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }


    public void startForegroundService() {
        String channelId = "channel";
        String channelName = "Channel Name";
        NotificationManager notifManager = (NotificationManager) getSystemService  (Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(channelId, channelName, importance);
            notifManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        int requestID = (int) System.currentTimeMillis();
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), requestID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("Smombie") // required
                .setContentText("Smombie 앱이 실행중입니다.")  // required
                .setDefaults(Notification.DEFAULT_ALL) // 알림, 사운드 진동 설정
                //.setAutoCancel(true) // 알림 터치시 반응 후 삭제
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setSmallIcon(android.R.drawable.btn_star)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.face))
                .setContentIntent(pendingIntent);


        //notifManager.notify(1, builder.build());
        startForeground(2, builder.build());

    }

//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Toast.makeText(getApplicationContext(), "onStartCommand 실행.", Toast.LENGTH_SHORT).show();
//        return super.onStartCommand(intent, flags, startId);
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        stopForeground(Service.STOP_FOREGROUND_DETACH);
        //stopForeground(true);
        Toast.makeText(getApplicationContext(), "ondestroy 실행.", Toast.LENGTH_SHORT).show();
        Log.e("test", "서비스의 onDestroy");
    }
}