package com.doulala.android.application;

import android.content.Context;

import com.doulala.android.base.di.ActivityScope;
import com.doulala.android.model.user.Account;
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



    /**
     *
     * 由于Account是可变的属性,所以不应该为singleton属.可以则需要通过Provider<Account>.get()进行实时获取.
     * 需要注意的是如果设置为Singleton,account即使动态获取到的也将是注入那一时刻被创建的对象,所以不能使用Scope标签.
     * 另外Account配合Rxbus将是更好的选择.
     *
    */

    @Provides
    public Account provideAccount() {
        return application.getAccount();
    }
}
