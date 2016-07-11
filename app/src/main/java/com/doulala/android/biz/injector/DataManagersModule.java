package com.doulala.android.biz.injector;

import android.content.Context;

import com.doulala.android.model.account.datamanager.AccountDataManager;
import com.doulala.android.model.account.datamanager.IAccountDataManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by doulala on 16/7/11.
 *
 * 统一处理DataManager注入的接口,这个Module会在BaseUIActivityModule中生效,
 * 用来注入的Presenter中需要的Datamanager
 *
 */

@Module
public class DataManagersModule {

    @Provides
    IAccountDataManager provideAccountDataManager(Context context) {

        return new AccountDataManager(context);
    }
}
