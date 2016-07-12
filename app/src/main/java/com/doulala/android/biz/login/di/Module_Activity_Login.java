package com.doulala.android.biz.login.di;

import com.doulala.android.biz.login.presenter.Presenter_Activity_Login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by doulala on 16/7/10.
 */

@Module
public class Module_Activity_Login {

    private Presenter_Activity_Login.View view;

    public Module_Activity_Login(Presenter_Activity_Login.View view) {

        this.view=view;

    }

    @Provides
    public  Presenter_Activity_Login.View providerView(){

        return this.view;

    }


}
