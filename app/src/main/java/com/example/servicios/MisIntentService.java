package com.example.servicios;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MisIntentService extends IntentService {
    MediaPlayer mp;
    String CHANNEL_ID="15463";
    NotificationCompat.Builder notificacion;
    private static final int idUnica=5123;
    public MisIntentService() {
        super("MisIntentService");
    }
    @Override
    public void onCreate() {
        Log.d("MISS", "S onCreate");
        Toast.makeText(this,"Reproduciendo", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("MISS", "Trabajando DUro");
        Toast.makeText(this,"Reproduciendo", Toast.LENGTH_SHORT).show();
        createNotificationChannel();
        mp= MediaPlayer.create(this,R.raw.music01);
        notificacion=new NotificationCompat.Builder(this,CHANNEL_ID);


            mp.start();


            notificacion.setSmallIcon(R.mipmap.ic_launcher_round);
            notificacion.setTicker("Reproduciendo");
            notificacion.setPriority(Notification.PRIORITY_HIGH);
            notificacion.setWhen(System.currentTimeMillis());
            notificacion.setContentTitle("Reproduciendo Audio");
            notificacion.setContentText("Reproduciendo sonido actual");

            Intent i=new Intent(this,Detalle.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
            notificacion.setContentIntent(pendingIntent);


            NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(idUnica,notificacion.build());

    }
    @Override
    public void onDestroy() {
        Log.d("MISS", "IS Destruido");
        mp.pause();
        super.onDestroy();

    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "fsdfg";
            String description = "fgtdgh";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
