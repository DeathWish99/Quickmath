package com.example.projectitdiv.quickmath;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BackgroundSoundService extends Service {
    MediaPlayer player;
    int a=0;
    int currentPosition=0;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if(a==0) {
            player = MediaPlayer.create(this, R.raw.idil);
            player.setLooping(true); // Set looping
            player.setVolume(10, 10);
            player.start();
            a=1;
        }else{
        }
        return START_STICKY;
    }
    public void onStart(Intent intent, int startId) {

    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }
    @Override
    public void onDestroy() {
        player.pause();
        a=0;
    }
    @Override
    public void onLowMemory() {
        player.pause();
        a=0;
    }
}



