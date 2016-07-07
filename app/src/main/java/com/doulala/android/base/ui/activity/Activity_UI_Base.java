package com.doulala.android.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.doulala.android.application.DApplication;
import com.doulala.android.model.user.Account;
import com.doulala.library.view.toast.IToastManager;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by doulala on 16/7/5.
 */
public class Activity_UI_Base extends Activity_Base {

    private static final String TAG = "Activity_UI_Base";

    private BaseUIActivityComponent baseUIActivityComponent;


    @Inject
    protected IToastManager toastManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    protected void inject() {

        baseUIActivityComponent = DaggerBaseUIActivityComponent.builder().appComponent(DApplication.get(Activity_UI_Base.this).getAppComponent()).baseUIActivityModule(new BaseUIActivityModule(Activity_UI_Base.this)).build();
        baseUIActivityComponent.inject(this);

    }

    public BaseUIActivityComponent component() {
        return baseUIActivityComponent;
    }


/*

    //可以使用这个方式动态获取实时的Account对象,Dagger Style.
    @Inject
    Provider<Account> account;

    protected Account getAccount() {
        return account.get();
    }
*/


}
