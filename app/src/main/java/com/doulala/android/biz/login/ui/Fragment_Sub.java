package com.doulala.android.biz.login.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doulala.android.R;
import com.doulala.android.base.ui.fragment.Fragment_Base;
import com.doulala.android.model.user.Account;

import javax.inject.Inject;

/**
 * Created by doulala on 16/7/6.
 */
public class Fragment_Sub extends Fragment_Base {

    View view;

    @Inject
    Account account;

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
        boolean isAccountNull = account == null;
    }
    /**
     * 重写inject完成具体组件的注入
     */
    @Override
    protected void inject() {
        super.inject();
        component().fragment_sub().inject(this);
    }
}
