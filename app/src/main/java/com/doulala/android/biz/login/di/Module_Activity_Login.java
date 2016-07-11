package com.doulala.android.biz.login.di;

import com.doulala.android.biz.login.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by doulala on 16/7/10.
 */

@Module
public class Module_Activity_Login {

    private LoginPresenter.View view;

    public Module_Activity_Login(LoginPresenter.View view) {

        this.view=view;

    }

    @Provides
    public  LoginPresenter.View providerView(){

        return this.view;

    }


}
