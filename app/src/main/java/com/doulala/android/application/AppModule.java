package com.doulala.android.application;

import android.content.Context;

import com.doulala.android.base.di.ActivityScope;
import com.doulala.library.manager.storage.ValueStorageManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by doulala on 16/7/5.
 */


@Module
public class AppModule {

    private DApplication application;

    public AppModule(DApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public ValueStorageManager provideValueStorageManager() {
        return new ValueStorageManager(this.application);
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
