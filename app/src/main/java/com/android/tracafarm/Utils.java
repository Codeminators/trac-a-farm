package com.android.tracafarm;

import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by raghav on 27/09/15.
 */
public class Utils extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(this);
    }
}
