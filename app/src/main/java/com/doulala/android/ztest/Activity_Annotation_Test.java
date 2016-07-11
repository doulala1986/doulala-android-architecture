package com.doulala.android.ztest;

import android.util.Log;

import com.doulala.android.model.account.Account;
import com.doulala.android.model.account.bus.AccountBus;
import com.doulala.library.bus.Bus;
import com.doulala.library.bus.RxbusActivity;

/**
 * Created by doulala on 16/7/8.
 */
public class Activity_Annotation_Test extends RxbusActivity {


    @Bus
    AccountBus bus=new AccountBus(new AccountBus.Callback() {
        @Override
        public void accountUpdated(Account newAccount) {
            Log.e("newAccount",newAccount.toString());
        }
    });




}
