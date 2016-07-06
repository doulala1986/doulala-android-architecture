package com.doulala.library.view.toast;

import android.app.Activity;

/**
 * Created by doulala on 16/7/5.
 */
public class ToastManager implements IToastManager {

    Activity activity;

    public ToastManager(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void show(String msg) {

    }

    @Override
    public void cancel() {

    }
}
