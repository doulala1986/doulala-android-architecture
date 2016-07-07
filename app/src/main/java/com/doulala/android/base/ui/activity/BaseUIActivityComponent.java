package com.doulala.android.base.ui.activity;

import com.doulala.android.application.AppComponent;
import com.doulala.android.base.di.ActivityComponents;
import com.doulala.android.base.di.ActivityScope;
import com.doulala.android.model.user.Account;
import com.doulala.library.manager.storage.ValueStorageManager;
import com.doulala.library.view.toast.IToastManager;

import dagger.Component;

/**
 * Created by doulala on 16/7/6.
 *
 * ActivityComponents 是专门用来统一处理SubComponent的接口,
 * 这么设计可以将对BaseComponent与具体业务处理分离.
 *
 */

@ActivityScope
@Component(modules = BaseUIActivityModule.class,dependencies= AppComponent.class)
public interface BaseUIActivityComponent extends ActivityComponents {

    /**
     *一个Component的只能依赖最多一个Scope,如果我希望向下传递上层Component的注入,需要在Component里声明.
     * 这里就是把AppComponent里的ValueStorageManager向下传递给了BaseFragmentComponent
    **/
    ValueStorageManager valueStorageManager();

    Account account();

    IToastManager toastManager();

    void inject(Activity_UI_Base activity);

}
