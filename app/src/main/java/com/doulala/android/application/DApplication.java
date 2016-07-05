package com.doulala.android.application;

import android.support.multidex.MultiDexApplication;

import com.doulala.android.application.crash.CrashHandler;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by doulala on 16/7/5.
 */
public class DApplication extends MultiDexApplication {


    @Override
    public void onCreate() {
        super.onCreate();
        initMemoryDetector();
        initError();
    }

    //region 处理内存泄露检测与内存泄露优化
    private void initMemoryDetector() {
        LeakCanary.install(this);
//        AntiMemoryLeak.install(this);
    }
    //endregion

    //region 初始化应用程序
    CrashHandler crashHandler;

    private void initError() {
        if (crashHandler == null)
            crashHandler = new CrashHandler();
        crashHandler.init(DApplication.this);
    }
    //endregion


}
