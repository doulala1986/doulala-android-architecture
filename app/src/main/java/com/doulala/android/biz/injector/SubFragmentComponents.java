package com.doulala.android.biz.injector;

import com.doulala.android.biz.main.di.Component_Fragment_UserInfo;
import com.doulala.android.biz.main.di.Module_Fragment_UserInfo;

/**
 * Created by doulala on 16/7/7.
 * <p/>
 * 统一处理SubFragmentComponent的接口
 */
public interface SubFragmentComponents {


    Component_Fragment_UserInfo fragment_userinfo(Module_Fragment_UserInfo module_fragment_userInfo);

}
