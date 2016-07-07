package com.doulala.android.application;


import com.doulala.android.model.user.Account;
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

    Account account();


    void inject(DApplication application);

}
