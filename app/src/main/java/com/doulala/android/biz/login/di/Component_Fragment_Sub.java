package com.doulala.android.biz.login.di;

import com.doulala.android.biz.login.ui.Fragment_Sub;

import dagger.Subcomponent;

/**
 * Created by doulala on 16/7/7.
 */

@Subcomponent
public interface Component_Fragment_Sub {


    void inject(Fragment_Sub fragment);
}
