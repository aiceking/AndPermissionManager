package com.wxystatic.andpermissionmanager;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by static on 2017/12/16/016.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
