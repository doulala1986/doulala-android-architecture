package com.doulala.library.bus;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by doulala on 16/7/8.
 */
public class RxbusFragment extends Fragment {


    private BusFactory busFactory;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        busFactory = new BusFactory(RxbusFragment.this);
        busFactory.init();
        busFactory.onCreate();
    }




    @Override
    public void onResume() {
        super.onResume();
        busFactory.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        busFactory.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        busFactory.onDestory();
    }

}
