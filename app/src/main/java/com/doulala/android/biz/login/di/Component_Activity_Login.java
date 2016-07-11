package com.doulala.android.biz.login.di;

import android.app.Activity;

import com.doulala.android.base.di.ActivityScope;
import com.doulala.android.base.ui.activity.BaseUIActivityComponent;
import com.doulala.android.biz.login.ui.Activity_Login;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by doulala on 16/7/7.
 */

@Subcomponent(modules = Module_Activity_Login.class)
public interface Component_Activity_Login {

    void inject(Activity_Login activity);

}
