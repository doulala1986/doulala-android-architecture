package com.doulala.android.base.ui.activity;

import com.doulala.android.base.di.ActivityScope;
import com.doulala.library.view.toast.IToastManager;
import com.doulala.library.view.toast.ToastManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by doulala on 16/7/6.
 */


@Module
public class BaseUIActivityModule {


    Activity_UI_Base activity;

    public BaseUIActivityModule(Activity_UI_Base activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    IToastManager provideToastManager() {

        return new ToastManager(this.activity);

    }

    @Provides
    @ActivityScope
    Activity_UI_Base provideUIActivity() {
        return this.activity;
    }


}
