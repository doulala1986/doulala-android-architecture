package com.doulala.android.base.ui.activity;

import android.content.Context;

import com.doulala.android.application.AppComponent;
import com.doulala.android.application.UIComponent;
import com.doulala.android.biz.injector.DataManagersModule;
import com.doulala.android.biz.injector.SubActivityComponents;
import com.doulala.android.base.di.ActivityScope;
import com.doulala.android.model.account.Account;
import com.doulala.library.manager.dialog.IDialogMananger;
import com.doulala.library.view.toast.IToastManager;

import dagger.Component;

/**
 * Created by doulala on 16/7/6.
 *
 * SubActivityComponents 是专门用来统一处理SubComponent的接口,
 * 这么设计可以将对BaseComponent与具体业务处理分离.
 *
 */

@ActivityScope
@Component(modules = {BaseUIActivityModule.class,DataManagersModule.class},dependencies= {AppComponent.class,UIComponent.class})
public interface BaseUIActivityComponent extends SubActivityComponents {

    /**
     *一个Component的只能依赖最多一个Scope,如果我希望向下传递上层Component的注入,需要在Component里声明.
     * 这里就是把AppComponent里的ValueStorageManager向下传递给了BaseFragmentComponent
    **/

    Account account();

    IToastManager toastManager();


    IDialogMananger dialogManager();

    /**
     *
     * 所有的Module一般都需要使用Context,由于Module操作一般是和业务,UI无关,所以使用appContext注入
     *
     *
     * @return DApplication.this
     */
    Context appContext();

    void inject(Activity_UI_Base activity);

}
