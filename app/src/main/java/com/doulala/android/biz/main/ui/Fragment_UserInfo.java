package com.doulala.android.biz.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doulala.android.R;
import com.doulala.android.base.ui.fragment.Fragment_UI_Base;
import com.doulala.android.biz.main.di.Module_Fragment_UserInfo;
import com.doulala.android.biz.main.presenter.Presenter_Fragment_UserInfo;
import com.doulala.android.model.account.Account;
import com.doulala.android.model.account.bus.AccountBus;
import com.doulala.library.bus.Bus;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by doulala on 16/7/6.
 */
public class Fragment_UserInfo extends Fragment_UI_Base implements Presenter_Fragment_UserInfo.View {

    View view;


    @Inject
    Presenter_Fragment_UserInfo presenter;

    public Fragment_UserInfo() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sub, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toastManager.show("123");
        presenter.start();

    }

    /**
     * 重写inject完成具体组件的注入
     */
    @Override
    protected void inject() {
        super.inject();
        component().fragment_userinfo(new Module_Fragment_UserInfo(Fragment_UserInfo.this)).inject(this);
    }

    @Bus()
    protected AccountBus accountBus = new AccountBus(new AccountBus.Callback() {
        @Override
        public void accountUpdated(Account newAccount) {
            Log.e("account in fragment", newAccount.toString());
        }
    });

    @Override
    public void showToken(String token) {

    }
}
