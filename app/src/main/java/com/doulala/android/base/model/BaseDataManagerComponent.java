package com.doulala.android.base.model;

import com.doulala.android.application.AppComponent;
import com.doulala.android.base.di.DataManagerScope;
import com.doulala.library.manager.storage.ValueStorageManager;

import dagger.Component;

/**
 * Created by doulala on 16/7/5.
 */


@DataManagerScope
@Component(dependencies = AppComponent.class)
public interface BaseDataManagerComponent {


    void inject(DataManager_Base base);

}
