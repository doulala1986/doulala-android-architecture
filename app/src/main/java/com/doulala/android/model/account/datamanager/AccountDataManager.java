package com.doulala.android.model.account.datamanager;

import android.content.Context;
import android.util.Log;

import com.doulala.android.base.model.DataManager_Base;
import com.doulala.android.model.account.Account;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by doulala on 16/7/5.
 */
public class AccountDataManager extends DataManager_Base implements IAccountDataManager {

    private static final String PREFERENCE_ACCOUNT_TOKEN = "PREFERENCE_ACCOUNT_TOKEN";

    @Inject
    public AccountDataManager(Context context) {
        super(context);
    }

    public Observable<Account> loginToServer(final String username, final String password) {

        return Observable.create(new Observable.OnSubscribe<Account>() {
            @Override
            public void call(Subscriber<? super Account> subscriber) {


                subscriber.onNext(new Account());
                subscriber.onCompleted();
            }
        }).doOnNext(new Action1<Account>() {
            @Override
            public void call(Account account) {
                valueStorageManager.set(PREFERENCE_ACCOUNT_TOKEN, account.getToken());
            }
        });
    }

    public Observable<String> tokenFromLocal() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String token = valueStorageManager.get(PREFERENCE_ACCOUNT_TOKEN, null);
                subscriber.onNext(token);
                subscriber.onCompleted();
            }
        });

    }

}

