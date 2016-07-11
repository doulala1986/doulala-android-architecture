package com.doulala.android.biz.injector;

import com.doulala.android.biz.login.di.Component_Activity_Login;
import com.doulala.android.biz.login.di.Module_Activity_Login;

/**
 * Created by doulala on 16/7/7.
 *
 * 统一处理SubActivityComponent的接口
 *
 */
public interface SubActivityComponents {

    Component_Activity_Login activity_login_component(Module_Activity_Login module);
}
