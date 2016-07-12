package com.doulala.android.biz.main.ui;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.doulala.android.R;
import com.doulala.android.base.ui.activity.Activity_UI_Base;
/**
 * Created by doulala on 16/7/12.
 */
public class Activity_Main extends Activity_UI_Base {


    Fragment_UserInfo fragment_userinfo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fragment_userinfo=new Fragment_UserInfo();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layout, fragment_userinfo);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void inject() {
        super.inject();
        component().activity_main_component().inject(this);
    }
}
