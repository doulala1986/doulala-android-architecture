package com.doulala.android.base;

import android.content.Context;

import com.doulala.library.manager.storage.ValueStorageManager;

/**
 * Created by doulala on 16/7/5.
 */
public class DataManager_Base {

    Context context;

    public DataManager_Base(Context context) {
        this.context = context.getApplicationContext();
        initValueStorageManager(this.context);
    }


    //region ValueStorageManager
    ValueStorageManager valueStorageManager;

    private void initValueStorageManager(Context context) {
        valueStorageManager = new ValueStorageManager(context.getApplicationContext());

    }
    //endregion


}
