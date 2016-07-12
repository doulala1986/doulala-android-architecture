package com.doulala.android.biz.main.di;

import com.doulala.android.base.di.ActivityScope;
import com.doulala.android.biz.main.ui.Activity_Main;

import dagger.Subcomponent;

/**
 * Created by doulala on 16/7/12.
 */
@ActivityScope
@Subcomponent
public interface Component_Activity_Main {

    void inject(Activity_Main activity);

}
