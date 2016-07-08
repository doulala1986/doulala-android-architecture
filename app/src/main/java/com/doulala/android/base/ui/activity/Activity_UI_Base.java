package com.doulala.android.base.ui.activity;

import android.content.res.ObbInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.doulala.android.application.DApplication;
import com.doulala.android.model.user.Account;
import com.doulala.android.model.user.bus.AccountBus;
import com.doulala.library.bus.Bus;
import com.doulala.library.bus.LifeCycle;
import com.doulala.library.view.toast.IToastManager;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void inject() {

        baseUIActivityComponent = DaggerBaseUIActivityComponent.builder().appComponent(DApplication.get(Activity_UI_Base.this).getAppComponent()).baseUIActivityModule(new BaseUIActivityModule(Activity_UI_Base.this)).build();
        baseUIActivityComponent.inject(this);

    }

    public BaseUIActivityComponent component() {
        return baseUIActivityComponent;
    }
    //endregion

    //region Account Getter


    //region (Deprecated)  可以使用这个方式获取实时的Account对象,Dagger Style.
    @Inject
    Provider<Account> account_dagger_inject;

    @Deprecated
    protected Account getAccountByDaggerStyle() {
        return account_dagger_inject.get();
    }
    //endregion


    @Bus(life = LifeCycle.onCreate)
    protected AccountBus accountBus = new AccountBus(new AccountBus.Callback() {
        @Override
        public void accountUpdated(Account newAccount) {
            onFindAccountUpdated(newAccount);
        }
    });

    protected void onFindAccountUpdated(Account newAccount) {
        this.account = newAccount;
    }

    private Account account;

    protected Account getAccount() {

        return account;
    }


    //endregion
    //endregion

}
