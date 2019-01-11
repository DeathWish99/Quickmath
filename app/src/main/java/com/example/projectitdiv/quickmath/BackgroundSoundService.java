package com.example.projectitdiv.quickmath;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    int a=0;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(a==0) {
            player = MediaPlayer.create(this, R.raw.idil);
            player.setLooping(true); // Set looping
            player.setVolume(20, 20);
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
    public void onStop() {
        player.stop();
    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        a=0;
    }
    public void onPause()
    {
        // When user presses home page
        Log.v(TAG, "Home Button Pressed");
        player.stop();
    }
    @Override
    public void onLowMemory() {
        player.stop();
        a=0;
    }
}



