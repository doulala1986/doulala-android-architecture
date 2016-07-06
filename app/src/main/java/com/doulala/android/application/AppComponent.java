package com.doulala.android.application;


import com.doulala.library.manager.storage.ValueStorageManager;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by doulala on 16/7/5.
 */


@Singleton
@Component(modules =AppModule.class)
public interface AppComponent {

    ValueStorageManager valueStorageManager();

    void inject(DApplication application);

}