package com.doulala.android.application;


import android.content.Context;

import com.doulala.android.model.account.Account;
import com.doulala.library.manager.storage.ValueStorageManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by doulala on 16/7/5.
 *
 * Application内分别可能有对UI开放的对象以及对Data开放的对象,通过SubComponent的方式进行区分.
 *
 * AppComponent:对通用对象的管理
 *
 * UIComponent:对UI特有对象的管理与传递,如ImageCacheManager等.
 *
 * DataComponent:对data特有对象的管理与传递,如ValueStoreageManager等
 *
 */


@Singleton
@Component(modules =AppModule.class)
public interface AppComponent {



    UIComponent uiComponent();

    DataComponent dataComponent();

    Account account();

    Context appContext();

    void inject(DApplication application);

}
