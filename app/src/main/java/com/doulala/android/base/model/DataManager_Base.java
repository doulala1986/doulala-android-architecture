package com.doulala.android.base.model;

import android.content.Context;
import android.util.Log;

import com.doulala.android.application.DApplication;
import com.doulala.library.manager.storage.ValueStorageManager;

import javax.inject.Inject;

/**
 * Created by doulala on 16/7/5.
 */
public class DataManager_Base {
    private static final String TAG = "DataManager_Base";

    Context context;

    private BaseDataManagerComponent component;

    @Inject
    protected ValueStorageManager valueStorageManager;


    public DataManager_Base(Context context) {
        this.context = context.getApplicationContext();
        component = DaggerBaseDataManagerComponent.builder().appComponent(DApplication.get(context).getAppComponent()).build();
        component.inject(this);
    }

    public void login() {
        Log.e(TAG, "login");
        valueStorageManager.set("user", "liyao");
    }

}
