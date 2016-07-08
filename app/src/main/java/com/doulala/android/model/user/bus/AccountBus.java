package com.doulala.android.model.user.bus;

import com.doulala.android.model.user.Account;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;

/**
 * Created by doulala on 16/7/8.
 */
public class AccountBus {

    public interface Callback {

        void accountUpdated(Account newAccount);

    }

    Callback callback;

    public AccountBus(Callback callback) {

        this.callback = callback;

    }


    @Subscribe(tags = {@Tag(Account.RXBUS_TAG_ACCOUNT_UPDATED)})
    public void accountUpdated(Account newAccount) {
        if (this.callback != null) {
            this.callback.accountUpdated(newAccount);
        }
    }


}
