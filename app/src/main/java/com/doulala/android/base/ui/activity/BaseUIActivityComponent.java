package com.doulala.android.base.ui.activity;

import com.doulala.android.application.AppComponent;
import com.doulala.android.base.di.ActivityScope;
import com.doulala.library.manager.storage.ValueStorageManager;
import com.doulala.library.view.toast.IToastManager;

import dagger.Component;

/**
 * Created by doulala on 16/7/6.
 */

@ActivityScope
@Component(modules = BaseUIActivityModule.class,dependencies= AppComponent.class)
public interface BaseUIActivityComponent {

    /**
     *一个Component的只能依赖最多一个Scope,如果我希望向下传递上层Component的注入,需要在Component里声明.
     * 这里就是把AppComponent里的ValueStorageManager向下传递给了BaseFragmentComponent
    **/
    ValueStorageManager valueStorageManager();

    IToastManager toastManager();

    void inject(Activity_UI_Base activity);

}
