package com.doulala.android.base.ui.fragment;

import android.content.Context;

import com.doulala.android.base.di.ActivityContextQualifier;
import com.doulala.android.biz.injector.DataManagersModule;
import com.doulala.android.biz.injector.SubFragmentComponents;
import com.doulala.android.base.di.FragmentScope;
import com.doulala.android.base.ui.activity.BaseUIActivityComponent;
import com.doulala.android.model.account.Account;
import com.doulala.library.manager.dialog.IDialogMananger;

import dagger.Component;

/**
 * Created by doulala on 16/7/6.
 * <p/>
 * Fragment的最上层Component
 */

@FragmentScope
@Component(dependencies = {BaseUIActivityComponent.class}, modules = {DataManagersModule.class})
public interface BaseFragmentComponent extends SubFragmentComponents {

    Account account();

    void inject(Fragment_UI_Base fragment);

}
