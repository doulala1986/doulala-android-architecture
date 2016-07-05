package com.doulala.android.base.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by doulala on 16/7/5.
 */
public class Fragment_Base extends Fragment {

    private Activity_UI_Base activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity= (Activity_UI_Base) context;
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




}
