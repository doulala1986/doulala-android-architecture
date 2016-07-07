package com.doulala.android.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.doulala.android.application.crash.CrashHandler;
import com.doulala.android.model.user.Account;
import com.doulala.library.manager.storage.ValueStorageManager;
import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

/**
 * Created by doulala on 16/7/5.
 */
public class DApplication extends MultiDexApplication {

    public static DApplication get(Context context) {

        return (DApplication) context.getApplicationContext();
    }

    private AppComponent appComponent;

    @Inject
    ValueStorageManager valueStorageManager;



    @Override
    public void onCreate() {
        super.onCreate();
        inject();
        initMemoryDetector();
        initError();
    }

    //region DI
    private void  inject(){
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(DApplication.this)).build();
        appComponent.inject(DApplication.this);
    }
    public AppComponent getAppComponent() {
        return appComponent;
    }
    //endregion

    //region 处理内存泄露检测与内存泄露优化
    private void initMemoryDetector() {
        LeakCanary.install(this);
//        AntiMemoryLeak.install(this);
    }
    //endregion

    //region 处理未捕获程序异常
    private CrashHandler crashHandler;

    private void initError() {
        if (crashHandler == null)
            crashHandler = new CrashHandler();
        crashHandler.init(DApplication.this);
    }
    //endregion



    //region 用户帐号
    private Account account=new Account();

    /**
     * @param account 当前的账户信息
     *
     */
    public void setAccount(Account account){

        this.account=account;

    }

    public Account getAccount() {
        return account;
    }
    //endregion
}
