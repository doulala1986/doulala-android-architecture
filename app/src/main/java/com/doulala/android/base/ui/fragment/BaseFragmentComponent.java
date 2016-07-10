package com.doulala.android.base.ui.fragment;

import com.doulala.android.base.di.FragmentComponents;
import com.doulala.android.base.di.FragmentScope;
import com.doulala.android.base.ui.activity.BaseUIActivityComponent;
import com.doulala.android.model.user.Account;

import dagger.Component;

/**
 * Created by doulala on 16/7/6.
 *
 * Fragment的最上层Component
 */

@FragmentScope
@Component(dependencies = {BaseUIActivityComponent.class})
public
interface BaseFragmentComponent extends FragmentComponents {

    Account account();

    void inject(Fragment_UI_Base fragment);

}
