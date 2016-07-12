package com.doulala.android.biz.login.presenter;

import android.content.Context;

import com.doulala.android.model.account.Account;
import com.doulala.android.model.account.datamanager.IAccountDataManager;

import javax.inject.Inject;

import dagger.Lazy;
import rx.functions.Action1;

/**
 * Created by doulala on 16/7/10.
 */
public class Presenter_Activity_Login {


    public interface View {

        void onPrevLogin();

        void onLoginSuccess(Account account);

        void onLoginFailed(String message);
    }

    private Presenter_Activity_Login.View view;

    @Inject
    Lazy<IAccountDataManager> accountDataManager;

    @Inject
    public Presenter_Activity_Login(Context context, Presenter_Activity_Login.View view) {
        super();
        this.view = view;
    }


    public void login() {
        IAccountDataManager manager = accountDataManager.get();

        manager.loginToServer("doulala","xxxx").subscribe(new Action1<Account>() {
            @Override
            public void call(Account account) {

            }
        });
    }

}
