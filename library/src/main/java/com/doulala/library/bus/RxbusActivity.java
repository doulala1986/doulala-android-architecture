package com.doulala.library.bus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by doulala on 16/7/8.
 */
public class RxbusActivity extends AppCompatActivity {


    private BusFactory busFactory;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        busFactory = new BusFactory(RxbusActivity.this);
        busFactory.init();
        busFactory.onCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        busFactory.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        busFactory.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        busFactory.onDestory();
    }


}
