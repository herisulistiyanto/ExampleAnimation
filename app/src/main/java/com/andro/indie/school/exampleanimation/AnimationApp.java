package com.andro.indie.school.exampleanimation;

import android.app.Application;

/**
 * Created by herisulistiyanto on 1/30/18.
 */

public class AnimationApp extends Application {

    private AnimUtil animUtil;

    @Override
    public void onCreate() {
        super.onCreate();
        animUtil = new AnimUtil(this);
    }

    public AnimUtil getAnimUtil() {
        return animUtil;
    }
}
