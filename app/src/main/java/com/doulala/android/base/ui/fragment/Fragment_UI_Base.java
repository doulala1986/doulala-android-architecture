package com.doulala.android.base.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import com.doulala.android.base.ui.activity.Activity_UI_Base;
import com.doulala.library.manager.dialog.IDialogMananger;
import com.doulala.library.manager.storage.ValueStorageManager;
import com.doulala.library.view.toast.IToastManager;

import javax.inject.Inject;

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
    protected IDialogMananger dialogMananger;


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
