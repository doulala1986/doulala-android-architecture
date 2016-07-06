package com.doulala.android.base.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.doulala.android.base.ui.activity.Activity_UI_Base;
import com.doulala.android.base.ui.activity.BaseUIActivityComponent;
import com.doulala.library.manager.storage.ValueStorageManager;
import com.doulala.library.view.toast.IToastManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by doulala on 16/7/5.
 */
public class Fragment_Base extends Fragment {

    Activity_UI_Base activity;
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
        boolean check = valueStorageManager == null;
    }

    public Activity_UI_Base UIActivity() {
        return activity;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindButterKnife(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindButterKnife();
    }

    //region ButterKnife 组件
    private Unbinder unbinder;

    private void bindButterKnife(View view) {
        unbindButterKnife();
        unbinder = ButterKnife.bind(view);
    }

    private void unbindButterKnife() {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
    //endregion

    private void inject() {
        baseFragmentComponent = DaggerBaseFragmentComponent.builder().baseUIActivityComponent(activity.component()).build();
        baseFragmentComponent.inject(this);
    }

}
