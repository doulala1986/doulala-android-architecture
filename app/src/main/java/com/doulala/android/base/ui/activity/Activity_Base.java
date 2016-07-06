package com.doulala.android.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by doulala on 16/7/5.
 */


 class Activity_Base extends AppCompatActivity {


    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        bindButterKnife();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        bindButterKnife();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        bindButterKnife();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindButterKnife();
    }



    //region ButterKnife 组件
    private Unbinder unbinder;

    private void bindButterKnife() {
        unbindButterKnife();
        unbinder = ButterKnife.bind(this);
    }

    private void unbindButterKnife() {
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
    //endregion

}
