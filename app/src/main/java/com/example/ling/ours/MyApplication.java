package com.example.ling.ours;

import android.app.Application;
import android.content.Intent;

/**
 * Created by Administrator on 2018/6/25 0025.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent("com.example.ling.ours.MusicService");
        startService(intent);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
