package com.doulala.android.biz.main.presenter;

import android.content.Context;

import com.doulala.android.base.di.ActivityContextQualifier;
import com.doulala.android.model.account.datamanager.IAccountDataManager;

import javax.inject.Inject;

import dagger.Lazy;
import rx.functions.Action1;

/**
 * Created by doulala on 16/7/12.
 */
public class Presenter_Fragment_UserInfo {


    public interface View {

        void showToken(String token);

    }

    @Inject
    Lazy<IAccountDataManager> accountDataManager;

    @Inject
    @ActivityContextQualifier
    protected Context context;

    @Inject
    protected Presenter_Fragment_UserInfo.View view;

    @Inject
    public Presenter_Fragment_UserInfo() {

    }


    public void start() {
        accountDataManager.get().tokenFromLocal().subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                if (view != null) {
                    view.showToken(s);
                }
            }
        });

    }

}
