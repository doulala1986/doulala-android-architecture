package com.doulala.android.base.ui.fragment;

import com.doulala.android.base.di.FragmentComponents;
import com.doulala.android.base.di.FragmentScope;
import com.doulala.android.base.ui.activity.BaseUIActivityComponent;
import com.doulala.android.model.user.Account;

import dagger.Component;

/**
 * Created by doulala on 16/7/6.
 */

@FragmentScope
@Component(dependencies = {BaseUIActivityComponent.class})
public
interface BaseFragmentComponent extends FragmentComponents {

    void inject(Fragment_Base fragment);

}
