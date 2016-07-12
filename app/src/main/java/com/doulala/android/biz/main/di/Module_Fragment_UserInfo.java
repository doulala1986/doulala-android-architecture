package com.doulala.android.biz.main.di;

import com.doulala.android.base.di.FragmentScope;
import com.doulala.android.biz.main.presenter.Presenter_Fragment_UserInfo;
import com.doulala.android.biz.main.ui.Fragment_UserInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by doulala on 16/7/12.
 */

@Module
public class Module_Fragment_UserInfo {

    Fragment_UserInfo fragment;

    public Module_Fragment_UserInfo(Fragment_UserInfo fragment) {

        this.fragment = fragment;

    }


    @Provides
    @FragmentScope
    Presenter_Fragment_UserInfo.View provideView() {
        return this.fragment;
    }

}
