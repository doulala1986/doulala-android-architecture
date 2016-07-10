package com.doulala.android.base.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.doulala.library.bus.RxbusFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by doulala on 16/7/10.
 * Fragment的框架基类,包括处理Butterknife,以及添加Rxbus能力.
 *
 */
public class Fragment_Base extends RxbusFragment {


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
