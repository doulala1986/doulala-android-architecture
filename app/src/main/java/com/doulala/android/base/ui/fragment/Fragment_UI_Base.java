package com.doulala.android.base.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.doulala.android.base.ui.activity.Activity_UI_Base;
import com.doulala.android.base.ui.activity.BaseUIActivityComponent;
import com.doulala.android.model.user.Account;
import com.doulala.library.bus.RxbusFragment;
import com.doulala.library.manager.storage.ValueStorageManager;
import com.doulala.library.view.toast.IToastManager;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by doulala on 16/7/5.
 *
 * Fragment的业务处理,主要处理依赖注入,对全局属性以及自身属性的注入
 *
 */
public class Fragment_UI_Base extends Fragment_Base {

    private Activity_UI_Base activity;


    private BaseFragmentComponent baseFragmentComponent;

    @Inject
    protected IToastManager toastManager;

    @Inject
    protected ValueStorageManager valueStorageManager;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (Activity_UI_Base) getActivity();
        inject();

    }

    public Activity_UI_Base activity() {
        return activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected void inject() {
        baseFragmentComponent = DaggerBaseFragmentComponent.builder().baseUIActivityComponent(activity.component()).build();
        baseFragmentComponent.inject(this);
    }

    protected BaseFragmentComponent component() {
        return baseFragmentComponent;
    }


}
