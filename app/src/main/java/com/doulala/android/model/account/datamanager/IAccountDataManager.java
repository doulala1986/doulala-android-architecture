package com.doulala.android.model.account.datamanager;

import com.doulala.android.model.account.Account;

import rx.Observable;

/**
 * Created by doulala on 16/7/11.
 */
public interface IAccountDataManager {

    Observable<Account> loginToServer(final String username, final String password);

    Observable<String> tokenFromLocal();
}
