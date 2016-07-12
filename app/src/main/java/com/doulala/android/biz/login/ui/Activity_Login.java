package com.doulala.android.biz.login.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.FrameLayout;

import com.doulala.android.R;
import com.doulala.android.base.ui.activity.Activity_UI_Base;
import com.doulala.android.biz.login.di.Module_Activity_Login;
import com.doulala.android.biz.login.presenter.Presenter_Activity_Login;
import com.doulala.android.model.account.Account;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by doulala on 16/7/6.
 */
public class Activity_Login extends Activity_UI_Base implements Presenter_Activity_Login.View {

    @BindView(R.id.layout)
    FrameLayout layout;


    @Inject
    Presenter_Activity_Login presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    /**
     * 重写inject完成具体组件的注入
     */
    @Override
    protected void inject() {
        super.inject();
        component().activity_login_component(new Module_Activity_Login(Activity_Login.this)).inject(this);
    }


    @Override
    protected void onFindAccountUpdated(Account newAccount) {
        super.onFindAccountUpdated(newAccount);
        Log.e("onFindAccountUpdated in biz activity", newAccount.toString());
    }




    //region Presenter_Activity_Login.View
    @Override
    public void onPrevLogin() {

    }

    @Override
    public void onLoginSuccess(Account account) {

    }

    @Override
    public void onLoginFailed(String message) {

    }

    //endregion
}
