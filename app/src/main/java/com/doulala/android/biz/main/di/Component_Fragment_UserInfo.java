package com.doulala.android.biz.main.di;

import com.doulala.android.base.di.FragmentScope;
import com.doulala.android.biz.main.ui.Fragment_UserInfo;

import dagger.Subcomponent;

/**
 * Created by doulala on 16/7/12.
 */
@FragmentScope
@Subcomponent(modules = Module_Fragment_UserInfo.class)
public interface Component_Fragment_UserInfo {

    void inject(Fragment_UserInfo fragment);
}
