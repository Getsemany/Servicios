package com.example.servicios;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Detalle extends AppCompatActivity {
    ImageButton play_pause;
    MediaPlayer mp;
    String CHANNEL_ID="15463";
    NotificationCompat.Builder notificacion;
    private static final int idUnica=5123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        createNotificationChannel();
    play_pause=findViewById(R.id.btnPlay_Pause);
    mp= MediaPlayer.create(this,R.raw.music01);
    notificacion=new NotificationCompat.Builder(this,CHANNEL_ID);
        final Context context=this;
    play_pause.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onClick(View view) {
            if(mp.isPlaying()){
                mp.pause();
                play_pause.setImageResource(R.drawable.play);

            }else{
                mp.start();
                play_pause.setImageResource(R.drawable.stop);
                Toast.makeText(context,"Reproduciendo", Toast.LENGTH_SHORT).show();
                notificacion.setSmallIcon(R.mipmap.ic_launcher_round);
                notificacion.setTicker("Reproduciendo");
                notificacion.setPriority(Notification.PRIORITY_HIGH);
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setContentTitle("Reproduciendo Audio");
                notificacion.setContentText("Reproduciendo sonido actual");

                Intent intent=new Intent(context,Detalle.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                notificacion.setContentIntent(pendingIntent);


                NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(idUnica,notificacion.build());
            }
        }
    });

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
