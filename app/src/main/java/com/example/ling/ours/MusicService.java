package com.example.ling.ours;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Administrator on 2018/6/24 0024.
 */

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;


    @Override
    public void onCreate() {
        super.onCreate();
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.side);
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
        }
        Log.e("MusicService","OnCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("MusicService","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Log.e("MusicService","onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MusicService","onBind");
        return null;
    }
}
