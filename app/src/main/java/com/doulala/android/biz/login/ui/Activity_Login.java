package com.doulala.android.biz.login.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.FrameLayout;

import com.doulala.android.R;
import com.doulala.android.base.ui.activity.Activity_UI_Base;
import com.doulala.android.base.ui.fragment.Fragment_Base;
import com.doulala.android.model.user.Account;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import dagger.Lazy;

/**
 * Created by doulala on 16/7/6.
 */
public class Activity_Login extends Activity_UI_Base {

    @BindView(R.id.layout)
    FrameLayout layout;

    Fragment_Sub fragment_sub;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Fragment_Sub fragment_sub = new Fragment_Sub();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout, fragment_sub);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    /**
     * 重写inject完成具体组件的注入
     */
    @Override
    protected void inject() {
        super.inject();
        component().activity_login_component().inject(this);
    }
}
